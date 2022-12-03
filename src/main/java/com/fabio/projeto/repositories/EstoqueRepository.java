package com.fabio.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.projeto.entidade.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

}
