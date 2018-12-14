package com.brasilprev.loja.builder;

import com.brasilprev.loja.dominio.Categoria;

public class CategoriaBuilder {
    private String nome = "categoria";

    private CategoriaBuilder(){
    }

    public static CategoriaBuilder umaCategoria(){
        return new CategoriaBuilder();
    }

    public Categoria build(){
        return Categoria.criar(nome);
    }
}
