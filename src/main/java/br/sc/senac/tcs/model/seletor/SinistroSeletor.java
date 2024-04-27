package br.sc.senac.tcs.model.seletor;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;

public class SinistroSeletor extends BaseSeletor {

	private Integer id;
	private String tipo;
	@Column(name = "DT_HORA")
	private LocalDateTime dataInicio;
	@Column(name = "DT_HORA")
	private LocalDateTime dataFinal;
	@Column(name = "DT_HORA")
	private LocalTime horario;
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
