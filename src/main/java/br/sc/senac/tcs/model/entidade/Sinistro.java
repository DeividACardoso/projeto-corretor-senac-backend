package br.sc.senac.tcs.model.entidade;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private LocalDate data;
	private LocalTime horario;
	private String descricao;
	
	@ManyToOne
    @JoinColumn(name = "seguro_id", nullable = false)
    private Seguro seguro;

	public Sinistro(Integer id, String tipo, 
			LocalDate data, LocalTime horario, String descricao, Seguro seguro) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.data = data;
		this.horario = horario;
		this.descricao = descricao;
		this.seguro = seguro;
	}
	
	
	
}
