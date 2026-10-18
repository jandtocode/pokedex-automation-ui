package com.jandtocode.stepdefinition;

import com.jandtocode.model.BusquedaPokemon;
import com.jandtocode.question.EvolucionPokemonMostrada;
import com.jandtocode.question.NombrePokemoMostrado;
import com.jandtocode.task.AbrirNavegadorPokedex;
import com.jandtocode.task.EncontrarPokemonBuscador;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class BuscarPokemonStepDefinition {

    @Dado("que Ash abre el navegador en la página de la Pokédex")
    public void que_ash_abre_el_navegador_en_la_pagina_de_la_pokedex() {
        theActorCalled("Ash").attemptsTo(AbrirNavegadorPokedex.enLaPagina());
    }
    @Cuando("busca el Pokémon {string}")
    public void busca_el_pokemon(String nombre) {

        theActorInTheSpotlight().attemptsTo(
                EncontrarPokemonBuscador.llamado(nombre)
        );

    }
    @Entonces("el nombre mostrado corresponde a {string}")
    public void el_nombre_mostrado_corresponde_a(String nombrePokemon) {
        String nombreEsperado = BusquedaPokemon.desde(nombrePokemon).nombreEnPantalla();
       theActorInTheSpotlight().should(
               seeThat(new NombrePokemoMostrado(), equalToIgnoringCase(nombreEsperado))
       );
    }
    @Entonces("la evolución mostrada es {string}")
    public void la_evolucion_mostrada_es(String esperado) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(EvolucionPokemonMostrada.enLaPantalla()).isEqualToIgnoringCase(esperado)
        );
    }
}
