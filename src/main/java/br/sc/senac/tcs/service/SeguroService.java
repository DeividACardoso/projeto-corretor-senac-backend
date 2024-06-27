package br.sc.senac.tcs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.repository.SeguroRepository;
import br.sc.senac.tcs.model.seletor.SeguroSeletor;
import br.sc.senac.tcs.model.specification.SeguroSpecification;
import jakarta.transaction.Transactional;

@Service
public class SeguroService {

	@Autowired
	private SeguroRepository seguroRepository;

	@Transactional
	public List<Seguro> listarTodos() {
		return seguroRepository.findAll();
	}

	public Seguro listarPorId(Integer id) {
		return seguroRepository.findById(id).get();
	}

	public Seguro salvar(Seguro novoSeguro) {
		return seguroRepository.save(novoSeguro);
	}

	public Object atualizar(Seguro seguroPAtualizar) {
		return seguroRepository.save(seguroPAtualizar);
	}

	public boolean delete(Integer id) {
		Optional<Seguro> seguroOptional = seguroRepository.findById(id);
		if (seguroOptional.isPresent()) {
			seguroRepository.deleteById(id);
			return true;
		} else {
			throw new IllegalArgumentException("Seguro with ID " + id + " does not exist.");
		}
	}

	public List<Seguro> comFiltros(SeguroSeletor seletor) {
		Specification<Seguro> specification = SeguroSpecification.comFiltros(seletor);
		return seguroRepository.findAll(specification);
	}


}
