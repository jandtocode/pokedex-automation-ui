package com.jandtocode.task;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.environment.SystemEnvironmentVariables;

public class AbrirNavegadorPokedex {

    private static final String PAGINA_INICIO = "pages.home";

    public static Performable enLaPagina() {

        String url = EnvironmentSpecificConfiguration
                .from(SystemEnvironmentVariables.currentEnvironmentVariables())
                .getProperty(PAGINA_INICIO);

        return Task.where("{0} abre el navegador en la página de la Pokédex: " + url, Open.url(url));
    }

    private AbrirNavegadorPokedex() {
    }
}
