package br.sc.senac.tcs.service;

import java.time.LocalDate;
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
		validarData(novoSeguro);
		return seguroRepository.save(novoSeguro);
	}

	public void validarData(Seguro seguro){
		LocalDate dataAtual = LocalDate.now();
		if(seguro.getDtInicioVigencia().isAfter(dataAtual) || seguro.getDtFimVigencia().isBefore(dataAtual)){
			seguro.setAtivo(false);
		} else if(seguro.getDtInicioVigencia().isBefore(dataAtual) && seguro.getDtFimVigencia().isAfter(dataAtual)){
			seguro.setAtivo(true);
		}
	}

	public Object atualizar(Seguro seguroPAtualizar) {
		LocalDate dataAtual = LocalDate.now();
		if(seguroPAtualizar.getDtInicioVigencia().isAfter(dataAtual) || seguroPAtualizar.getDtFimVigencia().isBefore(dataAtual)){
			seguroPAtualizar.setAtivo(false);
		} else if(seguroPAtualizar.getDtInicioVigencia().isBefore(dataAtual) && seguroPAtualizar.getDtFimVigencia().isAfter(dataAtual)){
			seguroPAtualizar.setAtivo(true);
		}
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

    public List<Seguro> segurosCliente(Integer idCliente) {
		return seguroRepository.findAllByClienteId(idCliente);
    }

    public List<Seguro> segurosVeiculo(Integer idVeiculo) {
		return seguroRepository.findAllByVeiculoId(idVeiculo);
    }


}
