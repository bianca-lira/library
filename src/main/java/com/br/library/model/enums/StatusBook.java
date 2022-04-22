package com.br.library.model.enums;

public enum StatusBook {
    AVALIABLE ("Disponível"),
    UNVALIABLE("Indisponível"),
    AWAITING_ARRIVAL("Aguandando chegada"),
    ;

    private final String value;
    StatusBook(String value) {
        this.value = value;
    }
}
