package br.sc.senac.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
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
}
