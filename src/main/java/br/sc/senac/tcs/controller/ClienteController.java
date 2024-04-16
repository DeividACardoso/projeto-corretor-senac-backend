package br.sc.senac.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/list")
    Iterable<Cliente> list() {
        return clienteRepository.findAll();
    }

}
