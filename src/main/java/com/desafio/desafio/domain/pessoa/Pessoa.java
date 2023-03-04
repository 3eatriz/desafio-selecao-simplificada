package com.desafio.desafio.domain.pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Pessoa")
@Table(name = "pessoas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private Long posicaoFila;

    public Pessoa(DadosCadastroPessoa dados){
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.posicaoFila = dados.posicaoFila();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoPessoa dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        
        if(dados.idade() != null){
            this.idade = dados.idade();
        }

    }
}
