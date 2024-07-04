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
import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.entidade.Sinistro;
import br.sc.senac.tcs.model.seletor.SinistroSeletor;
import br.sc.senac.tcs.service.SinistroService;

@RestController
@RequestMapping(path = "/api/sinistro")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)

public class SinistroController {

	@Autowired
	private SinistroService sinistroService;

	@GetMapping(path = "/todos")
	public List<Sinistro> listarTodos() {
		return sinistroService.listarTodos();
	}

	@GetMapping(path = "/{id}")
	public Sinistro listarPorId(@PathVariable Integer id) {
		return sinistroService.listarPorId(id);
	}

	@PostMapping(path = "/novo")
	public Sinistro salvarSinistro(@RequestBody Sinistro novoSinistro) throws CampoInvalidoException {
		return sinistroService.salvar(novoSinistro);
	}

	@PostMapping(path = "/filtro")
	public List<Sinistro> listarComSeletor(@RequestBody SinistroSeletor seletor) {
		return sinistroService.listarComSeletor(seletor);
	}

	@PutMapping(path = "/atualizar/{id}")
	public Sinistro atualizar(@PathVariable Integer id, @RequestBody Sinistro sinistroPAtualizar) throws CampoInvalidoException {
		return sinistroService.atualizar(id, sinistroPAtualizar);
	}

	@DeleteMapping("/delete/{id}")
	public boolean excluir(@PathVariable Integer id) {
		boolean excluiu = sinistroService.excluir(id);
		return excluiu;
	}
	
}
