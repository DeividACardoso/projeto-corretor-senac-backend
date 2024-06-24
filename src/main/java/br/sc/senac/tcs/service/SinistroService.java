package br.sc.senac.tcs.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Sinistro;
import br.sc.senac.tcs.model.repository.SinistroRepository;
import br.sc.senac.tcs.model.seletor.SinistroSeletor;
import br.sc.senac.tcs.model.specification.SinistroSpecification;
import jakarta.transaction.Transactional;

@Service
public class SinistroService {

	@Autowired
	private SinistroRepository sinistroRepository;

	@Transactional
	public List<Sinistro> listarTodos() {
		return sinistroRepository.findAll();
	}

	public Sinistro listarPorId(Integer id) {
		return sinistroRepository.findById(id).get();

	}

	public Sinistro salvar(Sinistro novoSinistro) throws CampoInvalidoException {
		validarCamposObrigatorios(novoSinistro);
		return sinistroRepository.save(novoSinistro);
	}

	private void validarCamposObrigatorios(Sinistro novoSinistro) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(novoSinistro.getTipo(), "tipo");
		mensagemValidacao += validarCampoData(novoSinistro.getData(), "data");
		mensagemValidacao += validarCampoHora(novoSinistro.getHorario(), "horario");
//		mensagemValidacao += validarCampoDataHora(novoSinistro.getDataHora(), "dt_hora");
		mensagemValidacao += validarCampoString(novoSinistro.getDescricao(), "descricao");

		if (!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoHora(LocalTime valorCampo, String nomeCampo) {
		if (valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}
	
	private String validarCampoData(LocalDate valorCampo, String nomeCampo) {
		if (valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	public List<Sinistro> listarComSeletor(SinistroSeletor seletor) {
		Specification<Sinistro> specification = SinistroSpecification.comFiltros(seletor);
		return sinistroRepository.findAll(specification);
	}

	public Sinistro atualizar(Integer id, Sinistro sinistroPAtualizar) {
		return sinistroRepository.save(sinistroPAtualizar);
	}

	public boolean excluir(Integer id) {
		boolean excluiu = false;
		if (sinistroRepository.existsById(id)) {
			sinistroRepository.deleteById(id);
			excluiu = true;
		}
		return excluiu;
	}

}
