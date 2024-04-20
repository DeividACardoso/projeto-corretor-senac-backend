package br.sc.senac.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.model.entidade.Corretor;
import br.sc.senac.tcs.model.repository.CorretorRepository;
import jakarta.transaction.Transactional;

@Service
public class CorretorService {

	@Autowired
	private CorretorRepository corretorRepository;

	@Transactional
	public List<Corretor> listarTodos() {
		return corretorRepository.findAll();
	}

	public Corretor listarPorId(Integer id) {
		return corretorRepository.findById(id).get();
	}

}
