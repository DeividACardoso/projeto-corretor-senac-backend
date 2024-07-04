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
import br.sc.senac.tcs.model.entidade.Corretor;
import br.sc.senac.tcs.model.seletor.CorretorSeletor;
import br.sc.senac.tcs.service.CorretorService;

@RestController
@RequestMapping(path = "/api/corretor")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class CorretorController {

	@Autowired
	private CorretorService corretorService;

	@GetMapping(path = "/todos")
	public List<Corretor> listarTodosCorretores() {
		return corretorService.listarTodos();
	}

	@GetMapping(path = "/{id}")
	public Corretor listarPorId(@PathVariable Integer id) {
		return corretorService.listarPorId(id);
	}

	@PostMapping
	public Corretor salvarCorretor(@RequestBody Corretor novoCorretor) throws CampoInvalidoException {
		return corretorService.salvar(novoCorretor);
	}

	@PostMapping("/filtro")
	public List<Corretor> listarComSeletor(@RequestBody CorretorSeletor seletor) {
		return corretorService.listarComSeletor(seletor);
	}

	@PutMapping(path = "/atualizar/{id}")
	public Corretor atualizar(@PathVariable Integer id, @RequestBody Corretor corretorPAtualizar) throws CampoInvalidoException {
		return corretorService.atualizar(id, corretorPAtualizar);
	}

	@DeleteMapping("/delete/{id}")
	public boolean excluir(@PathVariable Integer id) {
		boolean excluiu = corretorService.excluir(id);
		return excluiu;
	}

	@GetMapping("/email/{email}")
	public Corretor listarPorEmail(@PathVariable String email) {
		return corretorService.listarPorEmail(email);
	}

}
