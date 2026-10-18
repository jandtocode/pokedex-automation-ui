package com.jandtocode.task;

import com.jandtocode.interaction.ResponderAlerta;
import com.jandtocode.model.BusquedaPokemon;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.jandtocode.userinterface.PokedexLocators.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static org.hamcrest.CoreMatchers.not;

public class EncontrarPokemonBuscador implements Task {

    private final String textoBuscado;
    private static final int ESPERA_MAXIMA_SEGUNDOS = 10;

    public EncontrarPokemonBuscador(String textoBuscado) {
        this.textoBuscado = textoBuscado;
    }

    public static EncontrarPokemonBuscador llamado(String textoBuscado) {
        return instrumented(EncontrarPokemonBuscador.class, textoBuscado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Modelo
        BusquedaPokemon busqueda = BusquedaPokemon.desde(textoBuscado);

        actor.attemptsTo(Enter.theValue(busqueda.nombre()).into(CAMPO_BUSQUEDA));

        actor.attemptsTo(Click.on(BOTON_BUSCAR));

        busqueda.genero().ifPresent(genero ->
                actor.attemptsTo(ResponderAlerta.con(genero.codigoAlerta())));

        // La búsqueda solo termina cuando el resultado reemplaza al "???" inicial
        actor.attemptsTo(
                WaitUntil.the(NOMBRE_POKEMON, not(containsText(SIN_RESULTADO)))
                        .forNoMoreThan(ESPERA_MAXIMA_SEGUNDOS).seconds()
        );

    }
}
