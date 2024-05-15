package br.sc.senac.tcs.model.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String telefone;
    private String email;
    private String senha;

    // @JsonBackReference
    // @OneToMany(mappedBy = "corretor")
    // private List<Seguro> seguros;

}
