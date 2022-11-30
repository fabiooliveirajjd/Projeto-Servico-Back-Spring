package com.fabio.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.projeto.entidade.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
