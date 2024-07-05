package br.sc.senac.tcs.model.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.sc.senac.tcs.model.entidade.Corretor;

@Repository
public interface CorretorRepository extends JpaRepository<Corretor, Integer> {

	List<Corretor> findAll(Specification<Corretor> specification);

	Corretor getReferenceById(Integer id);

	Corretor getByEmail(String email);	

	UserDetails findByEmail(String email);

	
}
