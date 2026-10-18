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

    public static final Target EVOLUCION_POKEMON = Target
            .the("evolución del Pokémon")
            .located(By.cssSelector("td.dato-evolucion"));

    // --- Pokédex visual (los botones y la pantalla negra) ---

    public static final Target BOTON_ENCENDER = Target
            .the("botón On de la Pokédex")
            .located(By.cssSelector("button[data-action='on']"));

    public static final Target BOTON_DERECHA = Target
            .the("botón derecha de la Pokédex")
            .located(By.cssSelector("[data-action='right']"));

    public static final Target BOTON_ABAJO = Target
            .the("botón abajo de la Pokédex")
            .located(By.cssSelector("[data-action='down']"));

    public static final Target BOTON_CENTRO = Target
            .the("botón centro de la Pokédex")
            .located(By.cssSelector("[data-action='select']"));

    public static final Target ITEMS_DE_LA_PANTALLA = Target
            .the("Pokémon que muestra la pantalla de la Pokédex")
            .located(By.cssSelector("div.pantalla-pokedex ul li"));

    public static final Target ITEM_ACTIVO = Target
            .the("Pokémon resaltado en la pantalla de la Pokédex")
            .located(By.cssSelector("div.pantalla-pokedex ul li.activo"));
}
