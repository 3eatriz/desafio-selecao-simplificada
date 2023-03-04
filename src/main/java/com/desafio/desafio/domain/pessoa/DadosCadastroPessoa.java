package com.desafio.desafio.domain.pessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPessoa(
    @NotBlank
    String nome,

    @NotNull
    Integer idade,

    @NotNull
    Long posicaoFila
) {
    
}
