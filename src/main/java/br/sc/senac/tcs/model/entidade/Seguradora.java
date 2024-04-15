package br.sc.senac.tcs.model.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seguradora")
@NoArgsConstructor
@Data
public class Seguradora {
 	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cpnj;
	private String ddd;
	private String telefone;
	private String email;
	
	public Seguradora(int id, String nome, String cpnj, String ddd, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpnj = cpnj;
		this.ddd = ddd;
		this.telefone = telefone;
		this.email = email;
	}
	
	
	
	

}
