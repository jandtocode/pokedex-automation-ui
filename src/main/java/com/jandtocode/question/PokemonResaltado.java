package com.jandtocode.question;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static com.jandtocode.userinterface.PokedexLocators.ITEM_ACTIVO;

public class PokemonResaltado {

    public static Question<String> enLaPantalla() {
        return Question.about("el Pokémon resaltado en la pantalla de la Pokédex")
                .answeredBy(actor -> Text.of(ITEM_ACTIVO)
                        .answeredBy(actor)
                        .replaceFirst("^\\d+\\s*", "")
                        .trim());
    }

    private PokemonResaltado() {}
}
