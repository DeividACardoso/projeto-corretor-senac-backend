package br.sc.senac.tcs.model.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.tcs.model.entidade.Seguro;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Integer> {
	
	List<Seguro> findAll(Specification<Seguro> specification);
}
