package br.sc.senac.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.model.entidade.Sinistro;
import jakarta.transaction.Transactional;

@Service
public class SinistroService {

	@Autowired
	private SinistroRepository sinistroRepository;

	@Transactional
	public List<Sinistro> listarTodos() {
		return sinistroRepository.findAll();
	}

	public Sinistro listarPorId(Integer id) {
		return sinistroRepository.findById(id).get();

	}

}
