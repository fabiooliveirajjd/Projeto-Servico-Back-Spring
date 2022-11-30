package com.fabio.projeto.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.projeto.entidade.Chamado;
import com.fabio.projeto.enuns.Status;
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

	public Chamado create(Chamado chamado) {
		Chamado novoTecnico = new Chamado();
		return repository.save(chamado);
	}

	public Chamado update(Integer id, Chamado chamado) {
		Chamado oldObj = findById(id);
		if (oldObj.getStatus().equals(Status.ENCERRADO)) {
			chamado.setDataFechamento(LocalDate.now());
		}
		oldObj = new Chamado();
		return repository.save(chamado);
	}

	public void delete(Integer id) {
		Chamado obj = findById(id);
		repository.deleteById(id);

	}

	

}
