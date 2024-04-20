package br.sc.senac.tcs.model.entidade;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity

@Table(name = "corretor")
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

	public Corretor(Integer id, String nome, String cpf, String ddd, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.ddd = ddd;
		this.telefone = telefone;
		this.email = email;
	}

    
    // @JsonBackReference
    // @OneToMany(mappedBy = "corretor")
    // private List<Seguro> seguros;
    
}
