package com.brasilprev.loja.infra.filtros;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrosDaApi {
    public String mensagem;
    public Integer status;
    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDateTime data;
}
