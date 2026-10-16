package com.jandtocode.userinterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PokedexLocators {

    public static final String SIN_RESULTADO = "???";

    public static final Target CAMPO_BUSQUEDA = Target
            .the("campo de búsqueda")
            .located(By.cssSelector("input.input-buscador"));

    public static final Target BOTON_BUSCAR = Target
            .the("botón Buscar")
            .located(By.cssSelector("button.boton-buscador"));

    public static final Target NOMBRE_POKEMON = Target
            .the("nombre del Pokémon")
            .located(By.cssSelector("span.nombre-pokemon"));
}
