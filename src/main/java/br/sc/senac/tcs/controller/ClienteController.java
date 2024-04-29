package br.sc.senac.tcs.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.service.ClienteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping(path = "/todos")
    public Iterable<Cliente> list() {
        return clienteService.findAll();
    }

    @GetMapping("{id}")
    public Cliente get(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.create(cliente);
    }

    @PutMapping("{id}")
    public Cliente update(@PathVariable Integer id, @RequestBody Cliente form) {
        return clienteService.update(id, form);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        clienteService.delete(id);
    }
}
