package br.sc.senac.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.sc.senac.tcs.controller.SeguroController;
import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.repository.ClienteRepository;
import br.sc.senac.tcs.model.repository.SeguroRepository;
import br.sc.senac.tcs.model.seletor.SeguroSeletor;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
	SeguroController seguroController;

    @Autowired
    SeguroRepository seguroRepo;

	SeguroSeletor seguroSeletor = new SeguroSeletor();

    @GetMapping
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public Cliente create(Cliente cliente) throws CampoInvalidoException {
        validarCamposObrigatorios(cliente);
        if (cliente.getCpf() != null) {
            removerMascara(cliente);
        }
        return clienteRepository.save(cliente);
    }

    private void validarCamposObrigatorios(Cliente cliente) throws CampoInvalidoException {
        String mensagemValidacao = "";
        mensagemValidacao += validarCampoString(cliente.getNome(), "nome");
        mensagemValidacao += validarCampoString(cliente.getCpf(), "cpf");
        mensagemValidacao += validarCampoString(cliente.getCnh(), "cnh");
        mensagemValidacao += validarCampoString(cliente.getTelefone(), "telefone");
        mensagemValidacao += validarCampoString(cliente.getEmail(), "email");
        mensagemValidacao += validarCampoString(cliente.getEstadoCivil(), "Estado Civil");
        mensagemValidacao += validarCampoString(cliente.getGenero(), "genero");
        mensagemValidacao += validarCampoString(cliente.getCep(), "cep");
        mensagemValidacao += validarCampoString(cliente.getUf(), "uf");
        mensagemValidacao += validarCampoString(cliente.getCidade(), "cidade");
        mensagemValidacao += validarCampoString(cliente.getComplemento(), "complemento");
        mensagemValidacao += validarCampoString(cliente.getRua(), "rua");
        mensagemValidacao += validarCampoString(cliente.getNumero(), "numero");

        if (!mensagemValidacao.isEmpty()) {
        	String mensagemValidacaoCompleta = "Informe: " + mensagemValidacao;
            throw new CampoInvalidoException(mensagemValidacaoCompleta);
        }
    }

    private String validarCampoString(String valorCampo, String nomeCampo) {
        if (valorCampo == null || valorCampo.trim().isEmpty()) {
            return nomeCampo + ", \n";
        }
        return "";
    }

    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public boolean delete(Integer idCliente) throws CampoInvalidoException {
        boolean retorno = false;
        Cliente c = clienteRepository.getById(idCliente);
        List<Seguro> segurosDoCliente = seguroRepo.findByCliente(c);
        if(segurosDoCliente.isEmpty()){
            clienteRepository.deleteById(idCliente);
        } else {
            throw new CampoInvalidoException("O cliente selecionado possui seguros associados, logo não pode ser excluído.");
        }
        return retorno;
    }   

    private void removerMascara(Cliente novoCliente) {
        String regex = "[\\s.\\-\\(\\)]+";
        System.out.println("Sem tirar Mascara: " + novoCliente.getCpf() + " " + novoCliente.getTelefone());
        String cpfSemMascara = novoCliente.getCpf().replaceAll(regex, "");
        String telefoneSemMascara = novoCliente.getTelefone().replaceAll(regex, "");
        novoCliente.setCpf(cpfSemMascara);
        novoCliente.setTelefone(telefoneSemMascara);
        System.out.println("Sem Mascara: " + novoCliente.getCpf() + " " + novoCliente.getTelefone());
    }
}
