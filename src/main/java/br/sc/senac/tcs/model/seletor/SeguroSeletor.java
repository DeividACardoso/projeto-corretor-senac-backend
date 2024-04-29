package br.sc.senac.tcs.model.seletor;


import java.time.LocalDate;

public class SeguroSeletor extends BaseSeletor{
	
	private String nomeSeguradora;
	private String nomeCorretor;
	private String nomeCliente;
	private LocalDate dtInicioComecoVigencia;
	private LocalDate dtFimComecoVigencia;
	private LocalDate dtInicioFimVigencia;
	private LocalDate dtFimFimVigencia;
	private Double menorRcfDanosMateriais;
	private Double maiorRcfDanosMateriais;
	private Double menorRofDanosFisicos;
	private Double maiorRofDanosFisicos;
	private Double menorFranquia;
	private Double maiorFranquia;
	private String carroReserva;
	
	public String getNomeSeguradora() {
		return nomeSeguradora;
	}
	public void setNomeSeguradora(String nomeSeguradora) {
		this.nomeSeguradora = nomeSeguradora;
	}
	public String getNomeCorretor() {
		return nomeCorretor;
	}
	public void setNomeCorretor(String nomeCorretor) {
		this.nomeCorretor = nomeCorretor;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
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
	public Double getMenorRcfDanosMateriais() {
		return menorRcfDanosMateriais;
	}
	public void setMenorRcfDanosMateriais(Double menorRcfDanosMateriais) {
		this.menorRcfDanosMateriais = menorRcfDanosMateriais;
	}
	public Double getMaiorRcfDanosMateriais() {
		return maiorRcfDanosMateriais;
	}
	public void setMaiorRcfDanosMateriais(Double maiorRcfDanosMateriais) {
		this.maiorRcfDanosMateriais = maiorRcfDanosMateriais;
	}
	public Double getMenorRofDanosFisicos() {
		return menorRofDanosFisicos;
	}
	public void setMenorRofDanosFisicos(Double menorRofDanosFisicos) {
		this.menorRofDanosFisicos = menorRofDanosFisicos;
	}
	public Double getMaiorRofDanosFisicos() {
		return maiorRofDanosFisicos;
	}
	public void setMaiorRofDanosFisicos(Double maiorRofDanosFisicos) {
		this.maiorRofDanosFisicos = maiorRofDanosFisicos;
	}
	public Double getMenorFranquia() {
		return menorFranquia;
	}
	public void setMenorFranquia(Double menorFranquia) {
		this.menorFranquia = menorFranquia;
	}
	public Double getMaiorFranquia() {
		return maiorFranquia;
	}
	public void setMaiorFranquia(Double maiorFranquia) {
		this.maiorFranquia = maiorFranquia;
	}
	public String getCarroReserva() {
		return carroReserva;
	}
	public void setCarroReserva(String carroReserva) {
		this.carroReserva = carroReserva;
	}
	
	
	
}
