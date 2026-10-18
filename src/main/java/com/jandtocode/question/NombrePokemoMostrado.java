package com.jandtocode.question;

import com.jandtocode.userinterface.PokedexLocators;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class NombrePokemoMostrado implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(PokedexLocators.NOMBRE_POKEMON).answeredBy(actor).trim();
    }

    @Override
    public String getSubject() {
        return "el nombre del Pokémon mostrado en pantalla";
    }
}
