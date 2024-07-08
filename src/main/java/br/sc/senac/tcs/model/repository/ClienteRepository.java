package br.sc.senac.tcs.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.tcs.model.entidade.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    public Optional<Cliente> findByEmail(String email);

    public List<Cliente> findAll(Specification<Cliente> specification);

}
