package br.sc.senac.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.model.entidade.Corretor;
import br.sc.senac.tcs.model.entidade.Seguradora;
import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.entidade.Veiculo;
import br.sc.senac.tcs.service.SeguroService;



@RestController
@RequestMapping(path = "/api/seguros")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class SeguroController {
	
	@Autowired
	private SeguroService seguroService;
	
	@GetMapping(path = "/todos")
	public List<Seguro> listarTodosSeguros(){
		return seguroService.listarTodos();
	}
	
	@GetMapping(path = "/{id}")
	public Seguro listarPorId(@PathVariable Integer id) {
		return seguroService.listarPorId(id);
	}

	@PostMapping
	public Seguro salvar(@RequestBody Seguro novoSeguro) {
//		Cliente cliente = novoSeguro.getIdCliente();
		Integer corretor = novoSeguro.getIdCorretor();
		Seguradora seguradora = novoSeguro.getSeguradora();
		Veiculo veiculo = novoSeguro.getVeiculo();
//		if(cliente == null) {
//			cliente = new Cliente();
//			novoSeguro.setCliente(cliente);
//		}
//		if(corretor == null) {
//			corretor = new Corretor();
//			novoSeguro.setIdCorretor();
//		}
		if(seguradora == null) {
			seguradora = new Seguradora();
			novoSeguro.setSeguradora(seguradora);
		}
		if(veiculo == null) {
			veiculo = new Veiculo();
			novoSeguro.setVeiculo(veiculo);
		}
		return seguroService.salvar(novoSeguro);
	}
	
	@PutMapping
	public boolean atualizar(@RequestBody Seguro seguroPAtualizar){
		return seguroService.atualizar(seguroPAtualizar) != null;
	}
}
