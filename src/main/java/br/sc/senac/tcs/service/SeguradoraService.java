package br.sc.senac.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Cliente;
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
		validarCamposObrigatorios(novaSeguradora);
		if (novaSeguradora.getCnpj() != null) {
			validarCnpj(novaSeguradora);
			validarTelefone(novaSeguradora);
		}
		return seguradoraRepository.save(novaSeguradora);
	}

	private void validarCamposObrigatorios(Seguradora novaSeguradora) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(novaSeguradora.getNome(), "nome");
		mensagemValidacao += validarCampoString(novaSeguradora.getCnpj(), "cnpj");
		mensagemValidacao += validarCampoString(novaSeguradora.getTelefone(), "telefone");
		mensagemValidacao += validarCampoString(novaSeguradora.getEmail(), "email");

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

	private String validarCnpj(Seguradora novaSeguradora) {
		if (novaSeguradora == null || novaSeguradora.getCnpj().trim().isEmpty()) {
			return "Informe o " + novaSeguradora.getCnpj() + " \n";
		}
		String regex = "[\\s.\\-\\(\\)\\/]+";
		String cnpjSemMascara = novaSeguradora.getCnpj().replaceAll(regex, "");
		novaSeguradora.setCnpj(cnpjSemMascara);
		return cnpjSemMascara;
	}

//	private String validarEmail(String valorCampo, String nomeCampo) {
//		if (valorCampo == null || valorCampo.trim().isEmpty()) {
//			String emailArroba = "@";
//			valorCampo.contains(emailArroba);
//			return "Informe o " + nomeCampo + " \n";
//		}
//		return "";
//	}
//
	private String validarTelefone(Seguradora novaSeguradora) {
		if (novaSeguradora == null || novaSeguradora.getTelefone().trim().isEmpty()) {
			return "Informe o " + novaSeguradora.getTelefone() + " \n";
		}
		String regex = "[\\s.\\-\\(\\)]+";
		String telefoneSemMascara = novaSeguradora.getTelefone().replaceAll(regex, "");
		novaSeguradora.setTelefone(telefoneSemMascara);
		return telefoneSemMascara;
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
		boolean excluiu = false;
		if (seguradoraRepository.existsById(id)) {
			seguradoraRepository.deleteById(id);
			excluiu = true;
		}
		return excluiu;
	}

}
