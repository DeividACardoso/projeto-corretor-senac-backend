package br.sc.senac.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Veiculo;
import br.sc.senac.tcs.service.VeiculoService;

@RestController
@RequestMapping(path = "/api/veiculo")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class VeiculoController {
		
		@Autowired
		private VeiculoService veiculoService;
		
		@GetMapping(path = "/todos")
		public List<Veiculo> listarTodos(){
			return veiculoService.listarTodos();
		}
		
		@GetMapping(path = "/{id}")
		public Veiculo listarPorId(@PathVariable Integer id) {
			return veiculoService.listarPorId(id);
		}
		
		@PostMapping(path = "/novo")
		public Veiculo salvar(@RequestBody Veiculo novoVeiculo) throws CampoInvalidoException {
			return veiculoService.salvar(novoVeiculo);
		}

		// @GetMapping(path = "/por-cliente/{idCliente}")
		// public List<Veiculo> listarPorCliente(@PathVariable Integer idCliente) {
		// 	return veiculoService.listarPorCliente(idCliente);
		// }
	
}
