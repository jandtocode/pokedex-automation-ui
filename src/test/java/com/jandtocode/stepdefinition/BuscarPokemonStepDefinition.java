package com.jandtocode.stepdefinition;

import com.jandtocode.task.AbrirNavegadorPokedex;
import com.jandtocode.task.EncontrarPokemonBuscador;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

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
    public void el_nombre_mostrado_corresponde_a(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Entonces("la evolución mostrada es {string}")
    public void la_evolucion_mostrada_es(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
