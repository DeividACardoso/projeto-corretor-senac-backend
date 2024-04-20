package br.sc.senac.tcs.model.seletor;


import java.time.LocalDate;

public class SeguroSeletor extends BaseSeletor{
	
	private Integer idSeguradora;
	private Integer idVeiculo;
	private Integer idCorretor;
	private Integer idCliente;
	private LocalDate dtInicioComecoVigencia;
	private LocalDate dtFimComecoVigencia;
	private LocalDate dtInicioFimVigencia;
	private LocalDate dtFimFimVigencia;
	private double menorRcfDanosMateriais;
	private double maiorRcfDanosMateriais;
	private double menorRofDanosFisicos;
	private double maiorRofDanosFisicos;
	private double menorFranquia;
	private double maiorFranquia;
	private String assistencia;
	private String carroReserva;
	
	public Integer getIdSeguradora() {
		return idSeguradora;
	}
	public void setIdSeguradora(Integer idSeguradora) {
		this.idSeguradora = idSeguradora;
	}
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public Integer getIdCorretor() {
		return idCorretor;
	}
	public void setIdCorretor(Integer idCorretor) {
		this.idCorretor = idCorretor;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public LocalDate getDtInicioComecoVigencia() {
		return dtInicioComecoVigencia;
	}
	public void setDtInicioComecoVigencia(LocalDate dtInicioComecoVigencia) {
		this.dtInicioComecoVigencia = dtInicioComecoVigencia;
	}
	public LocalDate getDtFimComecoVigencia() {
		return dtFimComecoVigencia;
	}
	public void setDtFimComecoVigencia(LocalDate dtFimComecoVigencia) {
		this.dtFimComecoVigencia = dtFimComecoVigencia;
	}
	public LocalDate getDtInicioFimVigencia() {
		return dtInicioFimVigencia;
	}
	public void setDtInicioFimVigencia(LocalDate dtInicioFimVigencia) {
		this.dtInicioFimVigencia = dtInicioFimVigencia;
	}
	public LocalDate getDtFimFimVigencia() {
		return dtFimFimVigencia;
	}
	public void setDtFimFimVigencia(LocalDate dtFimFimVigencia) {
		this.dtFimFimVigencia = dtFimFimVigencia;
	}
	public String getAssistencia() {
		return assistencia;
	}
	public void setAssistencia(String assistencia) {
		this.assistencia = assistencia;
	}
	public String getCarroReserva() {
		return carroReserva;
	}
	public void setCarroReserva(String carroReserva) {
		this.carroReserva = carroReserva;
	}
	public double getMenorRcfDanosMateriais() {
		return menorRcfDanosMateriais;
	}
	public void setMenorRcfDanosMateriais(double menorRcfDanosMateriais) {
		this.menorRcfDanosMateriais = menorRcfDanosMateriais;
	}
	public double getMaiorRcfDanosMateriais() {
		return maiorRcfDanosMateriais;
	}
	public void setMaiorRcfDanosMateriais(double maiorRcfDanosMateriais) {
		this.maiorRcfDanosMateriais = maiorRcfDanosMateriais;
	}
	public double getMenorRofDanosFisicos() {
		return menorRofDanosFisicos;
	}
	public void setMenorRofDanosFisicos(double menorRofDanosFisicos) {
		this.menorRofDanosFisicos = menorRofDanosFisicos;
	}
	public double getMaiorRofDanosFisicos() {
		return maiorRofDanosFisicos;
	}
	public void setMaiorRofDanosFisicos(double maiorRofDanosFisicos) {
		this.maiorRofDanosFisicos = maiorRofDanosFisicos;
	}
	public double getMenorFranquia() {
		return menorFranquia;
	}
	public void setMenorFranquia(double menorFranquia) {
		this.menorFranquia = menorFranquia;
	}
	public double getMaiorFranquia() {
		return maiorFranquia;
	}
	public void setMaiorFranquia(double maiorFranquia) {
		this.maiorFranquia = maiorFranquia;
	}
	
	
}
