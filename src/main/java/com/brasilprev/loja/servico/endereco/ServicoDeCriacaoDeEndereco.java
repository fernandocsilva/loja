package com.brasilprev.loja.servico.endereco;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.controller.endereco.AdicionaEnderecoHttpDto;
import com.brasilprev.loja.dominio.Endereco;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeCriacaoDeEndereco implements IServicoDeCriacaoDeEndereco {
    @Override
    public ConfirmacaoDeSucesso criar(AdicionaEnderecoHttpDto adicionaEnderecoHttpDto) {
        Endereco endereco = Endereco.criar(adicionaEnderecoHttpDto.rua, adicionaEnderecoHttpDto.cidade,
                adicionaEnderecoHttpDto.bairro, adicionaEnderecoHttpDto.cep,
                adicionaEnderecoHttpDto.estado);

        ConfirmacaoDeSucesso confirmacaoDeSucesso = new ConfirmacaoDeSucesso(endereco.getId());

        return confirmacaoDeSucesso;
    }
}
