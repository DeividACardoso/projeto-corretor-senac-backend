package br.sc.senac.tcs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.entidade.Veiculo;
import br.sc.senac.tcs.model.repository.ClienteRepository;
import br.sc.senac.tcs.model.repository.SeguroRepository;
import br.sc.senac.tcs.model.repository.VeiculoRepository;
import jakarta.transaction.Transactional;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private ClienteRepository clienteController;

	@Autowired
	private SeguroRepository seguroRepository;

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
		if (valorCampo != null && valorCampo.isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}
    public List<Veiculo> listarPorCliente(Integer idCliente) {
		Optional<Cliente> cliente = clienteController.findById(idCliente);
		return veiculoRepository.findByCliente(cliente.get());
    }

	public boolean delete(Integer id) {
		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
		if (veiculoOptional.isPresent()) {
			veiculoRepository.deleteById(id);
			return true;
		} else {
			throw new IllegalArgumentException("Veiculo with ID " + id + " does not exist.");
		}
	}

	public boolean verificarSeguro(Integer idVeiculo) {
		List<Seguro> seguros = seguroRepository.findAllByVeiculoId(idVeiculo);
		return seguros != null && !seguros.isEmpty();
	}
	
}
