package br.sc.senac.tcs.model.seletor;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;

public class SinistroSeletor extends BaseSeletor {

	private Integer id;
	private String tipo;
	@Column(name = "data")
	private LocalDate dataInicial;
	@Column(name = "data")
	private LocalDate dataFinal;
	@Column(name = "horario")
	private LocalTime horarioInicial;
	@Column(name = "horario")
	private LocalTime horarioFinal;
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
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
	public LocalTime getHorarioInicial() {
		return horarioInicial;
	}
	public void setHorarioInicial(LocalTime horarioInicial) {
		this.horarioInicial = horarioInicial;
	}
	public LocalTime getHorarioFinal() {
		return horarioFinal;
	}
	public void setHorarioFinal(LocalTime horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}