package br.sc.senac.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.model.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
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
        mensagemValidacao += validarCampoString(cliente.getTelefone(), "telefone");

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

    public Cliente update(Integer id, Cliente form) {
        Cliente clienteDb = findById(id);

        clienteDb.setNome(form.getNome());
        clienteDb.setEmail(form.getEmail());

        return clienteRepository.save(clienteDb);
    }

    public void delete(Integer id) {
        Cliente clienteDb = clienteRepository.findById(id).orElse(null);
        clienteRepository.delete(clienteDb);
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
