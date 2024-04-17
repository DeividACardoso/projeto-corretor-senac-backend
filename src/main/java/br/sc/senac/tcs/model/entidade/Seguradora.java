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
	private String cnpj;
	private String email;
	private String ddd;
	private String telefone;
	
	
	public Seguradora() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Seguradora(int id, String nome, String cnpj, String email, String ddd, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.ddd = ddd;
		this.telefone = telefone;
	}

	

}
