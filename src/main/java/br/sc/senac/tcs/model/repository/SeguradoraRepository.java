package br.sc.senac.tcs.model.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.tcs.model.entidade.Seguradora;

@Repository
public interface SeguradoraRepository extends JpaRepository<Seguradora, Integer> {
	
	List<Seguradora> findAll(Specification<Seguradora> specification); 
	

}
