package br.sc.senac.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.tcs.exception.SeguroVigenteException;
import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.service.CampoInvalidoException;
import br.sc.senac.tcs.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(path = "/todos")
    public Iterable<Cliente> list() {
        return clienteService.findAll();
    }

    @GetMapping("{id}")
    public Cliente listarPorId(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    @PostMapping("/novo")
    public Cliente create(@RequestBody Cliente cliente) throws CampoInvalidoException {
        return clienteService.create(cliente);
    }

    @PutMapping("{id}")
    public Cliente update(@PathVariable Integer id, @RequestBody Cliente form) {
        return clienteService.update(id, form);
    }

    @DeleteMapping("/delete-id/{id}")
    public boolean delete(@PathVariable Integer id) throws SeguroVigenteException {
        return clienteService.delete(id);
    }
}
