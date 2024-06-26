package br.sc.senac.tcs.model.seletor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;

public class SinistroSeletor extends BaseSeletor {

	private Integer id;
	private String tipo;
	@Column(name = "data")
	private LocalDateTime dataInicial;
	@Column(name = "data")
	private LocalDateTime dataFinal;
	@Column(name = "horario")
	private LocalDateTime horarioInicial;
	@Column(name = "horario")
	private LocalDateTime horarioFinal;
	private String descricao;
	

}