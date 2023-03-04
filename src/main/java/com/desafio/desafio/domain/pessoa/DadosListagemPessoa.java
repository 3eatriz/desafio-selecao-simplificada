package com.desafio.desafio.domain.pessoa;

public record DadosListagemPessoa(Long id, String nome, Integer idade, Long posicaoFila) {
    public DadosListagemPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getIdade(), pessoa.getPosicaoFila());
    }
}
