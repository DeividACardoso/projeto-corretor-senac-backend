package br.sc.senac.tcs.controller;

import java.util.List;

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

import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.seletor.SeguroSeletor;
import br.sc.senac.tcs.service.SeguroService;

@RestController
@RequestMapping(path = "/api/seguros")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class SeguroController {

	@Autowired
	private SeguroService seguroService = new SeguroService();

	@GetMapping(path = "/todos")
	public List<Seguro> listarTodosSeguros() {
		return seguroService.listarTodos();
	}

	@GetMapping(path = "/{id}")
	public Seguro listarPorId(@PathVariable Integer id) {
		return seguroService.listarPorId(id);
	}

	@PostMapping("/filtro")
	public List<Seguro> listarComSeletor(@RequestBody SeguroSeletor seletor) {
		return seguroService.comFiltros(seletor);
	}

	@PostMapping
	public Seguro salvar(@RequestBody Seguro novoSeguro) {
		return seguroService.salvar(novoSeguro);
	}

	@PutMapping
	public boolean atualizar(@RequestBody Seguro seguroPAtualizar) {
		return seguroService.atualizar(seguroPAtualizar) != null;
	}

	@DeleteMapping(path = "/delete-id/{id}")
	public boolean delete(@PathVariable Integer id) {
		return seguroService.delete(id);
	}

	@GetMapping("/seg-cliente/{idCliente}")
    public Iterable<Seguro> segurosCliente(@PathVariable Integer idCliente) {
        return seguroService.segurosCliente(idCliente);
    }
}