package com.desafio.desafio.domain.pessoa;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(
    @NotNull     
    Long id, 
    String nome, 
    Integer idade,
    Long posicaoFila
) {
    
}
