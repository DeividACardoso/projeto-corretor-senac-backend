package br.sc.senac.tcs.model.entidade;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class Seguro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	private Seguradora idSeguradora;
	private Veiculo veiculo;
	private Corretor corretor;
	private Cliente cliente;
	private double rcfDanosMateriais;
	private double rcfDanosFisicos;
	private LocalDate dtInicioVigencia;
	private LocalDate dtFimVigencia;
	private String numeroProposta;
	private double franquia;
	private boolean carroReserva;
	private String numApolice;
	
	public Seguro(int id, Veiculo veiculo, Corretor corretor, Cliente cliente, double rcfDanosMateriais,
			double rcfDanosFisicos, LocalDate dtInicioVigencia, LocalDate dtFimVigencia, String numeroProposta,
			double franquia, boolean carroReserva, String numApolice) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.corretor = corretor;
		this.cliente = cliente;
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

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Corretor getCorretor() {
		return corretor;
	}

	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
}
