package com.desafio.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.desafio.desafio.domain.pessoa.DadosAtualizacaoPessoa;
import com.desafio.desafio.domain.pessoa.DadosCadastroPessoa;
import com.desafio.desafio.domain.pessoa.DadosDetalhamentoPessoa;
import com.desafio.desafio.domain.pessoa.DadosListagemPessoa;
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

    @GetMapping
    public ResponseEntity<List<DadosListagemPessoa>> listar(){
        var page = repository.findAll().stream().map(DadosListagemPessoa::new).toList();
        return ResponseEntity.ok(page);
    }

    //Get organizado por fila
    @GetMapping("/organizado")
    public ResponseEntity<List<DadosListagemPessoa>> listarOrganizado(){
        var page = repository.findAllPessoasOrderedByPosicaoFilaDesc().stream().map(DadosListagemPessoa::new).toList();
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPessoa dados){
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
