package br.sc.senac.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Seguradora;
import br.sc.senac.tcs.model.repository.SeguradoraRepository;
import br.sc.senac.tcs.model.seletor.SeguradoraSeletor;
import br.sc.senac.tcs.model.specification.SeguradoraSpecification;
import jakarta.transaction.Transactional;

@Service
public class SeguradoraService {
	@Autowired
	private SeguradoraRepository seguradoraRepository;

	@Transactional
	public List<Seguradora> listarTodos() {
		return seguradoraRepository.findAll();
	}

	@Transactional
	public Seguradora listarPorId(Integer id) {
		return seguradoraRepository.findById(id).get();
	}

	public Seguradora salvar(Seguradora novaSeguradora) throws CampoInvalidoException {
		if (novaSeguradora.getEmail() != null && novaSeguradora.getNome() != null) {
			removerMascara(novaSeguradora);
		}
		return seguradoraRepository.save(novaSeguradora);
	}

	private void removerMascara(Seguradora novaSeguradora) {
		String regex = "[\\s.\\-\\(\\)]+";
		String cnpjSemMascara = novaSeguradora.getCnpj().replaceAll(regex, "");
		String telefoneSemMascara = novaSeguradora.getTelefone().replaceAll(regex, "");
		novaSeguradora.setCnpj(cnpjSemMascara);
		novaSeguradora.setTelefone(telefoneSemMascara);
	}

	public List<Seguradora> listarComSeletor(SeguradoraSeletor seletor) {
		Specification<Seguradora> specification = SeguradoraSpecification.comFiltros(seletor);
		return seguradoraRepository.findAll(specification);
	}

	public Seguradora atualizar(Integer id, Seguradora seguradoraPAtualizar) throws CampoInvalidoException {
		Seguradora seguradoraAtualizada = findById(id);
		seguradoraAtualizada.setNome(seguradoraPAtualizar.getNome());
		seguradoraAtualizada.setEmail(seguradoraPAtualizar.getEmail());
		seguradoraAtualizada.setCnpj(seguradoraPAtualizar.getCnpj());
		seguradoraAtualizada.setTelefone(seguradoraPAtualizar.getTelefone());
		return seguradoraRepository.save(seguradoraPAtualizar);
	}

	public Seguradora findById(Integer id) {
		return seguradoraRepository.findById(id).get();
	}

	public boolean excluir(Integer id) {
		if (seguradoraRepository.existsById(id)) {
			seguradoraRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
