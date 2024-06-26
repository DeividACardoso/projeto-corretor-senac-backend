package br.sc.senac.tcs.model.seletor;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class SinistroSeletor extends BaseSeletor {

	private Integer id;
	private String tipo;
	@Column(name = "DT_HORA")
	private LocalDateTime dataInicial;
	@Column(name = "DT_HORA")
	private LocalDateTime dataFinal;
	@Column(name = "DT_HORA")
	private LocalDateTime horarioInicial;
	@Column(name = "DT_HORA")
	private LocalDateTime horarioFinal;
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

	public LocalDateTime getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDateTime dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDateTime getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}

	public LocalDateTime getHorarioInicial() {
		return horarioInicial;
	}

	public void setHorarioInicial(LocalDateTime horarioInicial) {
		this.horarioInicial = horarioInicial;
	}

	public LocalDateTime getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(LocalDateTime horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}