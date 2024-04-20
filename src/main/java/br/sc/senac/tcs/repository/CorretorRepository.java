package br.sc.senac.tcs.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.senac.tcs.model.entidade.Corretor;


public interface CorretorRepository extends JpaRepository<Corretor, Integer> {
	
	List<Corretor> findAll(Specification<Corretor> specification);
	
	Corretor getReferenceById(Integer id);
	
	

}
