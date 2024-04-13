package br.sc.senac.tcs.model.entidade;

import java.time.LocalDate;

public class Seguro {
	private int id;
//	private int seguradoraId;
//	private int veiculoId;
//	private int corretorId;
//	private int clienteId;
	private double rcfDanosMateriais;
	private double rcfDanosFisicos;
	private LocalDate dtInicioVigencia;
	private LocalDate dtFimVigencia;
	private String numeroProposta;
	private double franquia;
	private boolean carroReserva;
	private String numApolice;
	
	public Seguro(int id, double rcfDanosMateriais, double rcfDanosFisicos, LocalDate dtInicioVigencia,
			LocalDate dtFimVigencia, String numeroProposta, double franquia, boolean carroReserva, String numApolice) {
		super();
		this.id = id;
		this.rcfDanosMateriais = rcfDanosMateriais;
		this.rcfDanosFisicos = rcfDanosFisicos;
		this.dtInicioVigencia = dtInicioVigencia;
		this.dtFimVigencia = dtFimVigencia;
		this.numeroProposta = numeroProposta;
		this.franquia = franquia;
		this.carroReserva = carroReserva;
		this.numApolice = numApolice;
	}

	public Seguro() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRcfDanosMateriais() {
		return rcfDanosMateriais;
	}

	public void setRcfDanosMateriais(double rcfDanosMateriais) {
		this.rcfDanosMateriais = rcfDanosMateriais;
	}

	public double getRcfDanosFisicos() {
		return rcfDanosFisicos;
	}

	public void setRcfDanosFisicos(double rcfDanosFisicos) {
		this.rcfDanosFisicos = rcfDanosFisicos;
	}

	public LocalDate getDtInicioVigencia() {
		return dtInicioVigencia;
	}

	public void setDtInicioVigencia(LocalDate dtInicioVigencia) {
		this.dtInicioVigencia = dtInicioVigencia;
	}

	public LocalDate getDtFimVigencia() {
		return dtFimVigencia;
	}

	public void setDtFimVigencia(LocalDate dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}

	public String getNumeroProposta() {
		return numeroProposta;
	}

	public void setNumeroProposta(String numeroProposta) {
		this.numeroProposta = numeroProposta;
	}

	public double getFranquia() {
		return franquia;
	}

	public void setFranquia(double franquia) {
		this.franquia = franquia;
	}

	public boolean isCarroReserva() {
		return carroReserva;
	}

	public void setCarroReserva(boolean carroReserva) {
		this.carroReserva = carroReserva;
	}

	public String getNumApolice() {
		return numApolice;
	}

	public void setNumApolice(String numApolice) {
		this.numApolice = numApolice;
	}
	
	
}
