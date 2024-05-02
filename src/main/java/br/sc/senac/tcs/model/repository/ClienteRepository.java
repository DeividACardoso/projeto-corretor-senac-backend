package br.sc.senac.tcs.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.sc.senac.tcs.model.entidade.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente,Integer>{
    
    
}
