package com.desafio.desafio.domain.pessoa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
    @Query("SELECT p FROM Pessoa p ORDER BY p.posicaoFila DESC")
    List<Pessoa> findAllPessoasOrderedByPosicaoFilaDesc();
}
