package com.brasilprev.loja.dominio;

import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CategoriaTest {
    @Test
    public void deveCriarUmaCategoria(){
        String nomeDaCategoria = "categoria";

        Categoria categoria = Categoria.criar(nomeDaCategoria);

        Assert.assertEquals(nomeDaCategoria, categoria.getNome());
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarUmaCategoriaSemNome(){
        String nomeDaCategoria = "";

        Categoria.criar(nomeDaCategoria);
    }
}
