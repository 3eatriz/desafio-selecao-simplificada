package com.desafio.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.desafio.desafio.domain.pessoa.DadosCadastroPessoa;
import com.desafio.desafio.domain.pessoa.DadosDetalhamentoPessoa;
import com.desafio.desafio.domain.pessoa.Pessoa;
import com.desafio.desafio.domain.pessoa.PessoaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder){
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);

        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
    }
}
