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

	private void validarCamposObrigatorios(Seguradora novaSeguradora) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(novaSeguradora.getNome(), "nome");
		mensagemValidacao += validarCnpj(novaSeguradora.getCnpj(), "cnpj");
		mensagemValidacao += validarTelefone(novaSeguradora.getTelefone(), "telefone");

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

	private String validarCnpj(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			valorCampo.replaceAll(".", "");
			valorCampo.replaceAll("-", "");
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	private String validarEmail(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			String emailArroba = "@";
			valorCampo.contains(emailArroba);
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	private String validarTelefone(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			valorCampo.replaceAll("-", "");
			valorCampo.replaceAll("(", "");
			valorCampo.replaceAll(")", "");
			valorCampo.replaceAll(" ", "");
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	public Seguradora salvar(Seguradora novaSeguradora) throws CampoInvalidoException {
		validarCamposObrigatorios(novaSeguradora);
		return seguradoraRepository.save(novaSeguradora);
	}

	public List<Seguradora> listarComSeletor(SeguradoraSeletor seletor) {
		Specification<Seguradora> specification = SeguradoraSpecification.comFiltros(seletor);
		return seguradoraRepository.findAll(specification);
	}

	public Seguradora atualizar(Integer id, Seguradora seguradoraPAtualizar) throws CampoInvalidoException {
		return seguradoraRepository.save(seguradoraPAtualizar);

	}

	public boolean excluir(Integer id) {
		boolean excluiu = false;
		if (seguradoraRepository.existsById(id)) {
			seguradoraRepository.deleteById(id);
			excluiu = true;
		}
		return excluiu;
	}

}
