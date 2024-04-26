package br.sc.senac.tcs.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.sc.senac.tcs.model.entidade.Corretor;

public interface CorretorRepository extends JpaRepository<Corretor,Integer >{
    
}
