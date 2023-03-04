package com.desafio.desafio.domain.pessoa;

public record DadosListagemPessoa(String nome, Integer idade, Long posicaoFila) {
    public DadosListagemPessoa(Pessoa pessoa){
        this(pessoa.getNome(), pessoa.getIdade(), pessoa.getPosicaoFila());
    }
}
