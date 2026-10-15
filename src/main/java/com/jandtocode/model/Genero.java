package com.jandtocode.model;

import java.util.Arrays;
import java.util.Optional;

public enum Genero {

    // \u2642 = ♂ y \u2640 = ♀ (escapes Unicode para evitar problemas de codificación entre editores)
    MACHO("macho", "1", "\u2642"),
    HEMBRA("hembra", "2", "\u2640");

    private final String sufijo;
    private final String codigoAlerta;
    private final String simbolo;

    Genero(String sufijo, String codigoAlerta, String simbolo) {
        this.sufijo = sufijo;
        this.codigoAlerta = codigoAlerta;
        this.simbolo = simbolo;
    }

    public String codigoAlerta() {
        return codigoAlerta;
    }

    public String simbolo() {
        return simbolo;
    }

    public static Optional<Genero> desdeSufijo(String texto) {
        return Arrays.stream(values())
                .filter(genero -> genero.sufijo.equalsIgnoreCase(texto))
                .findFirst();
    }
}
