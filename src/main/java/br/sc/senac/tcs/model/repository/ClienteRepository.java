package br.sc.senac.tcs.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.tcs.model.entidade.Cliente;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Integer >{
    
}
