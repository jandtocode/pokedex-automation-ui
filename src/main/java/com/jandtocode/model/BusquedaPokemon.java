package com.jandtocode.model;

import java.util.Optional;

public record BusquedaPokemon (String textoOriginal, String nombre, Optional<Genero> genero){

    private static final String SEPARADOR = "-";

    public static BusquedaPokemon desde(String texto) {
        String limpio = texto.trim();
        int posicion = limpio.lastIndexOf(SEPARADOR);

        if (posicion > 0) {
            Optional<Genero> genero = Genero.desdeSufijo(limpio.substring(posicion + 1));
            if (genero.isPresent()) {
                return new BusquedaPokemon(limpio, limpio.substring(0, posicion), genero);
            }
        }
        return new BusquedaPokemon(limpio, limpio, Optional.empty());
    }

    public String nombreEnPantalla() {
        return nombre + genero.map(Genero::simbolo).orElse("");
    }
}
