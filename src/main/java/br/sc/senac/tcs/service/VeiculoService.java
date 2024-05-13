package br.sc.senac.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Veiculo;
import br.sc.senac.tcs.model.repository.VeiculoRepository;
import jakarta.transaction.Transactional;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Transactional
	public List<Veiculo> listarTodos() {
		return veiculoRepository.findAll();
	}

	public Veiculo listarPorId(Integer id) {
		return veiculoRepository.findById(id).get();
	}

	public Veiculo salvar(Veiculo novoVeiculo) throws CampoInvalidoException {
		validarCamposObrigatorios(novoVeiculo);
		return veiculoRepository.save(novoVeiculo);
	}

	private void validarCamposObrigatorios(Veiculo veiculo) throws CampoInvalidoException {
		String mensagemValidacao = "";
		// mensagemValidacao += validarCamposString(veiculo.getAnoModelo(), "");
		mensagemValidacao += validarCamposString(veiculo.getBairro(), "");
		mensagemValidacao += validarCamposString(veiculo.getCep(), "");
		mensagemValidacao += validarCamposString(veiculo.getCidade(), "");
		mensagemValidacao += validarCamposString(veiculo.getMarca(), "");
		// mensagemValidacao += validarCampoString(veiculo.get, "");

		if (!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCamposString(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}
	
}
