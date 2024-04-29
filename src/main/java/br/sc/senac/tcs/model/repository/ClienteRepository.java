package br.sc.senac.tcs.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.senac.tcs.model.entidade.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
