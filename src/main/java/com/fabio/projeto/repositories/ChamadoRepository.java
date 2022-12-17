package com.fabio.projeto.repositories;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fabio.projeto.entidade.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

   @Query(value = "SELECT cha.valor FROM Chamado as cha "
   		+ "where cha.id_tecnico = :tecnico "
   		+ "and cha.id_cliente = :cliente "
   		+ "and cha.data_abertura  BETWEEN :dataIni  and :dataFim",
   		nativeQuery = true)
	public abstract List<BigDecimal> calcular(
			@Param("tecnico") Integer idTecnico,
			@Param("cliente") Integer idCliente,
 		    @Param("dataIni") Date data1,
 		    @Param("dataFim") Date data2);
   

	
}
 