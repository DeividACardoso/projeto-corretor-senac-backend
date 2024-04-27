package br.sc.senac.tcs.model.entidade;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")
@Data
@RequiredArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(length = 255, nullable = false)
	private int id;

	@Column(length = 255, nullable = false)
	private String nome;

	@Column(length = 11, nullable = false)
	private String cpf;

	@Column(nullable = false)
	@jakarta.persistence.Temporal(jakarta.persistence.TemporalType.DATE)
	private LocalDate dtNascimento;
    

	@Column(length = 255, nullable = false)
	private String email;

	@Column(length = 255, nullable = false)
	private String cnh;

	@Column(length = 255, nullable = false)
	private String ddd;

	@Column(length = 255, nullable = false)
	private String telefone;

	@Column(length = 255, nullable = false)
	private String estadoCivil;

	@Column(length = 255, nullable = false)
	private String genero;

	@Column(length = 255, nullable = false)
	private String rua;

	@Column(length = 255, nullable = false)
	private String bairro;

//	@ManyToOne
//	@JoinColumn(name = "corretor_id")
//	


}
