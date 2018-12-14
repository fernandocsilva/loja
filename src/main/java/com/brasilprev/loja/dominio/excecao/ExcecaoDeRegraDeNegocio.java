package com.brasilprev.loja.dominio.excecao;

public class ExcecaoDeRegraDeNegocio extends RuntimeException {
    public ExcecaoDeRegraDeNegocio(String message) {
        super(message);
    }

    public ExcecaoDeRegraDeNegocio() {
    }
}
