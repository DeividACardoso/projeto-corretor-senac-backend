package br.sc.senac.tcs.model.entidade;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
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
    
    @OneToMany
    @JoinColumn(name = "corretor_id")
    private List<Cliente> clientes;
    
    @OneToMany
    @JoinColumn(name = "corretor_id")
    private List<Seguro> seguros;
}
