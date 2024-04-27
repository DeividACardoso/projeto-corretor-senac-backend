package br.sc.senac.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.model.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente save(Cliente novoCliente) {
        return clienteRepository.save(novoCliente);
    }

    // public boolean delete(Cliente clienteDb) {
    //     boolean seguroVigente = clienteDb.getSeguros().
        
    //     return seguroVigente;
    // }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public Iterable<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

	public void delete(Cliente cliente) {
		
	}   
    
}
