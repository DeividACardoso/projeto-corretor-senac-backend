package br.sc.senac.tcs.model.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.entidade.Sinistro;

@Repository
public interface SinistroRepository extends JpaRepository<Sinistro, Integer> {

	List<Sinistro> findAll(Specification<Sinistro> specification);

	Sinistro getReferenceById(Integer id);

    List<Sinistro> findAllBySeguroId(Integer idSeguro);


}
