package br.sc.senac.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.model.entidade.Seguradora;
import br.sc.senac.tcs.repository.SeguradoraRepository;
import jakarta.transaction.Transactional;

@Service
public class SeguradoraService {
	@Autowired
	private SeguradoraRepository seguradoraRepository;

	@Transactional
	public List<Seguradora> listarTodos() {
		return seguradoraRepository.findAll();
	}

	public Seguradora listarPorId(Integer id) {
		return seguradoraRepository.findById(id).get();
	}

}
