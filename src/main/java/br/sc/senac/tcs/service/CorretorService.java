package br.sc.senac.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Corretor;
import br.sc.senac.tcs.model.repository.CorretorRepository;
import br.sc.senac.tcs.model.seletor.CorretorSeletor;
import br.sc.senac.tcs.model.specification.CorretorSpecification;
import jakarta.transaction.Transactional;

@Service
public class CorretorService {

	@Autowired
	private CorretorRepository corretorRepository;

	@Transactional
	public List<Corretor> listarTodos() {
		return corretorRepository.findAll();
	}

	public Corretor listarPorId(Integer id) {
		return corretorRepository.findById(id).get();
	}

	public Corretor salvar(Corretor novoCorretor) throws CampoInvalidoException {
		validarCamposObrigatorios(novoCorretor);
		return corretorRepository.save(novoCorretor);
	}

	public List<Corretor> listarComSeletor(CorretorSeletor seletor) {
		Specification<Corretor> specification = CorretorSpecification.comFiltros(seletor);
		return corretorRepository.findAll(specification);
	}

	public Corretor atualizar(Integer id, Corretor corretorPAtualizar) throws CampoInvalidoException {
		return corretorRepository.save(corretorPAtualizar);
	}

	public boolean excluir(Integer id) {
		boolean excluiu = false;
		if (corretorRepository.existsById(id)) {
			corretorRepository.deleteById(id);
			excluiu = true;
		}
		return excluiu;
	}

	private void validarCamposObrigatorios(Corretor novoCorretor) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(novoCorretor.getNome(), "nome");
		mensagemValidacao += validarCampoString(novoCorretor.getCpf(), "cnpj");
		mensagemValidacao += validarCampoString(novoCorretor.getTelefone(), "telefone");
		mensagemValidacao += validarCampoString(novoCorretor.getEmail(), "email");
		mensagemValidacao += validarCampoString(novoCorretor.getSenha(), "senha");

		if (!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

}
