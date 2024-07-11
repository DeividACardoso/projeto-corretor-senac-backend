package br.sc.senac.tcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.sc.senac.tcs.controller.SeguroController;
import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.repository.ClienteRepository;
import br.sc.senac.tcs.model.repository.SeguroRepository;
import br.sc.senac.tcs.model.seletor.ClienteSeletor;
import br.sc.senac.tcs.model.seletor.SeguroSeletor;
import br.sc.senac.tcs.model.specification.ClienteSpecification;

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
        if (cliente.getCpf() != null) {
            removerMascara(cliente);
        }
        validarCamposObrigatorios(cliente);
        validarCamposRepetidos(cliente);
        System.out.println(cliente);
        return clienteRepository.save(cliente);
    }

    private void validarCamposRepetidos(Cliente cliente) throws CampoInvalidoException {
        List<String> errorMessages = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findAll();

        for (Cliente c : clientes) {
            if (c.getCpf().equals(cliente.getCpf())) {
                errorMessages.add("CPF já cadastrado");
            }
            if (c.getEmail().equals(cliente.getEmail())) {
                errorMessages.add("Email já cadastrado");
            }
        }

        if (!errorMessages.isEmpty()) {
            throw new CampoInvalidoException(errorMessages);
        }
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

    @SuppressWarnings("deprecation")
    public boolean delete(Integer idCliente) throws CampoInvalidoException {
        List<Seguro> seguros = seguroRepo.findAllByClienteId(idCliente);
        seguroRepo.deleteAll(seguros);
        clienteRepository.deleteById(idCliente);
        return true;
    }

    @SuppressWarnings("deprecation")
    public boolean verificarSeguros(Integer idCliente) {
        boolean retorno = false;
        Cliente cliente = clienteRepository.getById(idCliente);
        List<Seguro> segurosDOCliente = seguroRepo.findByCliente(cliente);
        if (!segurosDOCliente.isEmpty()) {
            for (Seguro seguro : segurosDOCliente) {
                retorno = seguro.isAtivo();
            }
        }

        return retorno;
    }

    @SuppressWarnings("deprecation")
    public boolean verificarSegurosAtivos(Integer idCliente) {
        boolean retorno = false;
        Cliente cliente = clienteRepository.getById(idCliente);
        List<Seguro> segurosDOCliente = seguroRepo.findAllByClienteAndAtivoIsTrue(cliente);
        if (!segurosDOCliente.isEmpty()) {
            for (Seguro seguro : segurosDOCliente) {
                retorno = seguro.isAtivo();
            }
        }
        return retorno;
    }

    private void removerMascara(Cliente novoCliente) {
        String regex = "[\\s.\\-\\(\\)]+";
        String cpfSemMascara = novoCliente.getCpf().replaceAll(regex, "");
        String telefoneSemMascara = novoCliente.getTelefone().replaceAll(regex, "");
        novoCliente.setCpf(cpfSemMascara);
        novoCliente.setTelefone(telefoneSemMascara);
    }

    public void importarPlanilha() {

    }

    public Optional<Cliente> listarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public List<Cliente> comFiltros(ClienteSeletor seletor) {
        Specification<Cliente> specification = ClienteSpecification.comFiltros(seletor);
        return clienteRepository.findAll(specification);
    }
}
