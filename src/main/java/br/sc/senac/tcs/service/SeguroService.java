package br.sc.senac.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.repository.ClienteRepository;
import br.sc.senac.tcs.model.repository.CorretorRepository;
import br.sc.senac.tcs.model.repository.SeguroRepository;
import jakarta.transaction.Transactional;

@Service
public class SeguroService {

	@Autowired
	private SeguroRepository seguroRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CorretorRepository corretorRepository;
	
	@Transactional
	public List<Seguro> listarTodos() {
		return seguroRepository.findAll();
	}
	
	public Seguro listarPorId(Integer id) {
		return seguroRepository.findById(id).get();
	}

    public Seguro salvar(Seguro novoSeguro){
		

		return seguroRepository.save(novoSeguro);	
	}	

}
