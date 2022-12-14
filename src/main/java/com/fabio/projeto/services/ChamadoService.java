package com.fabio.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.projeto.entidade.Chamado;
import com.fabio.projeto.repositories.ChamadoRepository;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

//	public List<BigDecimal> calcular() {
//		return repository.calcular(null, null, null);
//	}

	public Chamado create(Chamado chamado) {
		return repository.save(chamado);
	}

	public Chamado update(Integer id, Chamado chamado) {
		Chamado oldObj = findById(id);
		oldObj = new Chamado();
		return repository.save(chamado);
	}

	public void delete(Integer id) {
		Chamado obj = findById(id);
		repository.deleteById(id);

	}

}
