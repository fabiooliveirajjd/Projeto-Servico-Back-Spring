package com.fabio.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.projeto.entidade.Faturamento;

public interface FaturamentoRepository extends JpaRepository<Faturamento, Integer> {

}
