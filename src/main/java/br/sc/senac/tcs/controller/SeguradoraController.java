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

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Seguradora;
import br.sc.senac.tcs.model.seletor.SeguradoraSeletor;
import br.sc.senac.tcs.service.SeguradoraService;

@RestController
@RequestMapping(path = "/api/seguradora")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class SeguradoraController {

	@Autowired
	private SeguradoraService seguradoraService;

	@GetMapping(path = "/todos")
	public List<Seguradora> listarTodosCorretoras() {
		return seguradoraService.listarTodos();
	}

	@GetMapping(path = "/{id}")
	public Seguradora listarPorId(@PathVariable Integer id) {
		return seguradoraService.listarPorId(id);
	}

	@PostMapping(path = "/novo")
	public Seguradora salvarSeguradora(@RequestBody Seguradora novaSeguradora) throws CampoInvalidoException {
		return seguradoraService.salvar(novaSeguradora);
	}

	@PostMapping("/filtro")
	public List<Seguradora> listarComSeletor(@RequestBody SeguradoraSeletor seletor) {
		return seguradoraService.listarComSeletor(seletor);
	}

	@PutMapping(path = "/atualizar/{id}")
	public Seguradora atualizar(@PathVariable Integer id, @RequestBody Seguradora seguradoraPAtualizar)
			throws CampoInvalidoException {
		return seguradoraService.atualizar(id, seguradoraPAtualizar);
	}

	@DeleteMapping("/delete/{id}")
	public boolean excluir(@PathVariable Integer id) {
		boolean excluiu = seguradoraService.excluir(id);
		return excluiu;
	}

}
