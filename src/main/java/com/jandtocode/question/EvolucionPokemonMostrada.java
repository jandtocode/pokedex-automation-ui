package com.jandtocode.question;

import com.jandtocode.userinterface.PokedexLocators;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public final class EvolucionPokemonMostrada {

    public static Question<String> enLaPantalla() {
        return Question.about("la evolución del Pokémon mostrada en pantalla")
                .answeredBy(actor -> Text.of(PokedexLocators.EVOLUCION_POKEMON)
                        .answeredBy(actor)
                        .trim());
    }

    private EvolucionPokemonMostrada() {
    }
}
