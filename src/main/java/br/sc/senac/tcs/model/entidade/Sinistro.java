package br.sc.senac.tcs.model.entidade;

import java.time.LocalDateTime;

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
	@Column(name = "DT_HORA")
	private LocalDateTime dataHora;
	private String descricao;

	public Sinistro(Integer id, String tipo, LocalDateTime dataHora, String descricao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.dataHora = dataHora;
		this.descricao = descricao;
	}

}
