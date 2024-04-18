package br.sc.senac.tcs.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.model.repository.ClienteRepository;
import br.sc.senac.tcs.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/todos")
    public Iterable<Cliente> listarTodosClientes() {
        return clienteService.listarTodos();
    }

    @GetMapping("{id}")
    public Cliente get(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("{id}")
    public Cliente update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente clienteDb = clienteService.findById(id);
        clienteDb.setNome(cliente.getNome());
        clienteDb.setBairro(cliente.getBairro());

        return clienteService.save(clienteDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        Cliente clienteDb = clienteService.findById(id);
        // clienteService.delete(clienteDb);
    }
}
