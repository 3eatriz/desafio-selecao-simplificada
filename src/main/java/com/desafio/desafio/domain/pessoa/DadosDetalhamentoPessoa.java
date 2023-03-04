package com.desafio.desafio.domain.pessoa;

public record DadosDetalhamentoPessoa(Long id, String nome, Integer idade, Long posicaoFila) {
    public DadosDetalhamentoPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getIdade(), pessoa.getPosicaoFila());
    }
}
