package com.jandtocode.task;

import com.jandtocode.model.BusquedaPokemon;
import com.jandtocode.question.PokemonResaltado;
import com.jandtocode.question.PokemonesVisibles;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

import static com.jandtocode.userinterface.PokedexLocators.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarPokemonBotones implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeleccionarPokemonBotones.class);
    private static final int ESPERA_MAXIMA_SEGUNDOS = 10;
    private static final Duration ESPERA_CAMBIO_DE_TANDA = Duration.ofSeconds(2);

    private final String textoBuscado;

    public SeleccionarPokemonBotones(String textoBuscado) {
        this.textoBuscado = textoBuscado;
    }

    public static SeleccionarPokemonBotones llamado(String textoBuscado) {
        return instrumented(SeleccionarPokemonBotones.class, textoBuscado);
    }

    @Override
    @Step("{0} selecciona el Pokémon #textoBuscado con los botones de la Pokédex")
    public <T extends Actor> void performAs(T actor) {
        String nombreBuscado = BusquedaPokemon.desde(textoBuscado).nombreEnPantalla();

        encenderPokedex(actor);
        List<String> tanda = avanzarHastaLaTanda(actor, nombreBuscado);
        bajarHastaElResaltado(actor, nombreBuscado, tanda.size());

        actor.attemptsTo(Click.on(BOTON_CENTRO));
    }

    private void encenderPokedex(Actor actor) {
        actor.attemptsTo(
                Click.on(BOTON_ENCENDER),
                WaitUntil.the(ITEM_ACTIVO, isVisible())
                        .forNoMoreThan(ESPERA_MAXIMA_SEGUNDOS).seconds()
        );
    }

    private List<String> avanzarHastaLaTanda(Actor actor, String nombreBuscado) {
        List<String> tanda = actor.asksFor(PokemonesVisibles.enLaPantalla());

        while (!contiene(tanda, nombreBuscado)) {
            actor.attemptsTo(Click.on(BOTON_DERECHA));
            List<String> siguiente = esperarCambioDeTanda(actor, tanda);

            if (siguiente.equals(tanda)) {
                // El front no avisa nada al llegar al final: el aviso lo damos nosotros
                String mensaje = "El Pokémon '" + textoBuscado + "' no se encuentra en la Pokédex: "
                        + "se recorrió toda la lista sin encontrarlo";
                LOGGER.error(mensaje);
                throw new AssertionError(mensaje);
            }
            tanda = siguiente;
        }
        return tanda;
    }

    // Tras pulsar derecha la tanda nueva tarda en llegar; si no cambia en el tiempo dado, es el final
    private List<String> esperarCambioDeTanda(Actor actor, List<String> anterior) {
        long limite = System.nanoTime() + ESPERA_CAMBIO_DE_TANDA.toNanos();
        List<String> actual = actor.asksFor(PokemonesVisibles.enLaPantalla());

        while (actual.equals(anterior) && System.nanoTime() < limite) {
            LockSupport.parkNanos(Duration.ofMillis(100).toNanos());
            actual = actor.asksFor(PokemonesVisibles.enLaPantalla());
        }
        return actual;
    }

    private void bajarHastaElResaltado(Actor actor, String nombreBuscado, int tamanoDeLaTanda) {
        for (int i = 0; i < tamanoDeLaTanda; i++) {
            if (actor.asksFor(PokemonResaltado.enLaPantalla()).equalsIgnoreCase(nombreBuscado)) {
                return;
            }
            actor.attemptsTo(Click.on(BOTON_ABAJO));
        }
    }

    private boolean contiene(List<String> tanda, String nombre) {
        return tanda.stream().anyMatch(item -> item.equalsIgnoreCase(nombre));
    }
}
