package com.uanderleivieira.mini_api_transacoes_bancarias.repository;

import com.uanderleivieira.mini_api_transacoes_bancarias.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findByContaId(Long contaId);
}
