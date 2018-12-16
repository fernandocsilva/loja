package com.brasilprev.loja.dominio;

import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EnderecoTest {
    private String rua;
    private String cidade;
    private String bairro;
    private String cep;
    private String estado;

    @Before
    public void Init(){
        rua = "Paulista";
        cidade = "São Paulo";
        bairro = "Teste";
        cep = "79015-150";
        estado = "SP";
    }

    @Test
    public void deveCriarUmEndereco(){
        Endereco endereco = Endereco.criar(rua, cidade, bairro, cep, estado);

        Assert.assertEquals(rua, endereco.getRua());
        Assert.assertEquals(bairro, endereco.getBairro());
        Assert.assertEquals(cep, endereco.getCep());
        Assert.assertEquals(cidade, endereco.getCidade());
        Assert.assertEquals(estado, endereco.getEstado());
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarEnderecoSemCep(){
        String cepNulo = null;

        Endereco endereco = Endereco.criar(rua, cidade, bairro, cepNulo, estado);
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarEnderecoSemRua(){
        String ruaNula = null;

        Endereco endereco = Endereco.criar(ruaNula, cidade, bairro, cep, estado);
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarEnderecoSemBairro(){
        String bairroNulo = null;

        Endereco endereco = Endereco.criar(rua, cidade, bairroNulo, cep, estado);
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarEnderecoSemCidade(){
        String cidadeNula = null;

        Endereco endereco = Endereco.criar(rua, cidadeNula, bairro, cep, estado);
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarEnderecoSemEstado(){
        String estadoNulo = null;

        Endereco endereco = Endereco.criar(rua, cidade, bairro, cep, estadoNulo);
    }
}
