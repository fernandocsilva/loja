package com.brasilprev.loja.controller;

public class ConfirmacaoDeSucesso {
    public Long identificador;

    public ConfirmacaoDeSucesso() {
    }

    public ConfirmacaoDeSucesso(Long identificador) {
        this.identificador = identificador;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }
}
