package com.jandtocode.stepdefinition;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

    @Before
    public void preparar_el_escenario() {

        OnStage.setTheStage(new OnlineCast());
    }
}
