package com.jandtocode.question;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static com.jandtocode.userinterface.PokedexLocators.ITEMS_DE_LA_PANTALLA;

public class PokemonesVisibles {
    public static Question<List<String>> enLaPantalla() {
        return Question.about("los Pokémon visibles en la pantalla de la Pokédex")
                .answeredBy(actor -> ITEMS_DE_LA_PANTALLA.resolveAllFor(actor).stream()
                        .map(WebElementFacade::getText)
                        .map(texto -> texto.replaceFirst("^\\d+\\s*", "").trim())
                        .toList());
    }

    private PokemonesVisibles() {
    }
}
