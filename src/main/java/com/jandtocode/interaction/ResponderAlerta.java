package com.jandtocode.interaction;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ResponderAlerta implements Interaction {

    private static final Duration ESPERA_MAXIMA = Duration.ofSeconds(10);
    private final String respuesta;

    public ResponderAlerta(String respuesta) {
        this.respuesta = respuesta;
    }

    public static ResponderAlerta con(String respuesta) {
        return instrumented(ResponderAlerta.class, respuesta);
    }

    @Override
    @Step("{0} responde '#respuesta' en la alerta del navegador")
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Alert alerta = new WebDriverWait(driver, ESPERA_MAXIMA)
                .until(ExpectedConditions.alertIsPresent());
        alerta.sendKeys(respuesta);
        alerta.accept();
    }
}
