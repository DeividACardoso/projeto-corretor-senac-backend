package br.sc.senac.tcs.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.tcs.model.entidade.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
