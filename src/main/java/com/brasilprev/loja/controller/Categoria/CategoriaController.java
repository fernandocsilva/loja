package com.brasilprev.loja.controller.Categoria;

import com.brasilprev.loja.servico.categoria.CategoriaDTO;
import com.brasilprev.loja.servico.categoria.IServicoDeConsultaDeCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/v1/categorias")
public class CategoriaController {

    private IServicoDeConsultaDeCategoria servicoDeConsultaDeCategoria;

    @Autowired
    public CategoriaController(IServicoDeConsultaDeCategoria servicoDeConsultaDeCategoria) {
        this.servicoDeConsultaDeCategoria = servicoDeConsultaDeCategoria;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> obterTodasAsCategorias(){
        List<CategoriaDTO> categorias = servicoDeConsultaDeCategoria.obterTodos();

        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> obterCategoriaPor(@PathVariable(value = "id") Long id){
        Optional<CategoriaDTO> categoriaDTOEncontrada = servicoDeConsultaDeCategoria.obterPor(id);

        return new ResponseEntity<>(categoriaDTOEncontrada.get(), HttpStatus.OK);
    }
}
