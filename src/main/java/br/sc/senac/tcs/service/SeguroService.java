package br.sc.senac.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.repository.ClienteRepository;
import br.sc.senac.tcs.model.repository.CorretorRepository;
import br.sc.senac.tcs.model.repository.SeguroRepository;
import br.sc.senac.tcs.model.seletor.SeguroSeletor;
import br.sc.senac.tcs.model.specification.SeguroSpecification;
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
//		 Optional<Cliente> cliente = clienteRepository.findById(novoSeguro.getIdCliente());
//		 novoSeguro.setIdCliente(cliente);
//		
//		 Optional<Corretor> corretor = corretorRepository.findById(novoSeguro.getIdCorretor());
//		 novoSeguro.setCorretor(corretor.get());

		return seguroRepository.save(novoSeguro);	
	}

	public Object atualizar(Seguro seguroPAtualizar) {
		return seguroRepository.save(seguroPAtualizar);
	}

	public boolean delete(Integer id) {
		seguroRepository.deleteById(id);
		return true;
	}

	public List<Seguro> listarComSeletor(SeguroSeletor seletor) {
		Specification<Seguro> specification = SeguroSpecification.comFiltros(seletor);
		return seguroRepository.findAll(specification);
	}

	
	
}
