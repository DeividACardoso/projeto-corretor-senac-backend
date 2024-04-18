package br.sc.senac.tcs.model.entidade;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sinistro")
@NoArgsConstructor
@Data
public class Sinistro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipo;
	@Column(name = "DT_SINISTRO")
	private LocalDate dtSinistro;
	private LocalTime horario;
	private String descricao;

}
