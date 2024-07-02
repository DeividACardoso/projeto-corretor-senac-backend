package br.sc.senac.tcs.model.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.model.entidade.Seguro;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Integer> {

	List<Seguro> findAll(Specification<Seguro> specification);

	List<Seguro> findByCliente(Cliente cliente);

	Iterable<Seguro> findAllByClienteId(Integer idCliente);

    Iterable<Seguro> findAllByVeiculoId(Integer idVeiculo);

}
