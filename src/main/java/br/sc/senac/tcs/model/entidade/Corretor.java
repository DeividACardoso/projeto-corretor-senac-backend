package br.sc.senac.tcs.model.entidade;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "corretor")
@Data
public class Corretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String ddd;
    private String telefone;
    private String email;
    private String senha;
    
    @OneToMany(mappedBy = "id")
    private List<Cliente> clientes;
    
    @OneToMany(mappedBy = "id")
    private List<Seguro> seguros;
}