package com.fabio.projeto.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fabio.projeto.entidade.Cliente;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query(value = "SELECT * FROM cliente c WHERE c.nome = :nome", 
	nativeQuery = true)
	public List<Cliente> buscarPorNome(@Param("nome") String nome);

   public List<Cliente> findByOrderByNome();
}
