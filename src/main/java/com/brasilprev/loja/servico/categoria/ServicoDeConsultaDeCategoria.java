package com.brasilprev.loja.servico.categoria;

import com.brasilprev.loja.dominio.Categoria;
import com.brasilprev.loja.infra.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoDeConsultaDeCategoria implements IServicoDeConsultaDeCategoria {
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    public ServicoDeConsultaDeCategoria(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDTO> obterTodos() {
        List<Categoria> categoriasEncontradas = categoriaRepositorio.findAll();

        List<CategoriaDTO> categoriasDTO = categoriasEncontradas.stream().map(this::montarCategoriaDTO)
                .collect(Collectors.toList());

        return categoriasDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CategoriaDTO> obterPor(Long id) {
        Optional<Categoria> categoriaEncontrada = categoriaRepositorio.findById(id);

        return categoriaEncontrada.map(this::montarCategoriaDTO);
    }

    private CategoriaDTO montarCategoriaDTO(Categoria categoria){
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.id = categoria.getId();
        categoriaDTO.nome = categoria.getNome();

        return categoriaDTO;
    }
}
