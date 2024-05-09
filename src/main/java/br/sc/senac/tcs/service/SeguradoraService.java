package br.sc.senac.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Seguradora;
import br.sc.senac.tcs.model.repository.SeguradoraRepository;
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

	public Seguradora inserir(Seguradora novaSeguradora) throws CampoInvalidoException {
		validarCamposObrigatorios(novaSeguradora);
		return seguradoraRepository.save(novaSeguradora);
	}

	private void validarCamposObrigatorios(Seguradora seguradora) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(seguradora.getNome(), "nome");
		mensagemValidacao += validarCampoString(seguradora.getCnpj(), "cnpj");
		mensagemValidacao += validarCampoString(seguradora.getTelefone(), "telefone");
		mensagemValidacao += validarCampoString(seguradora.getEmail(), "email");

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
