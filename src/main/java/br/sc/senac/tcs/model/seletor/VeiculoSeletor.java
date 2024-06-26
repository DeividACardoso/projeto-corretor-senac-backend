package br.sc.senac.tcs.model.seletor;

import java.time.LocalDateTime;


public class VeiculoSeletor extends BaseSeletor{

	private Integer marca;
	private String modelo;
	private String tipoCombustivel;
	private LocalDateTime ano;
	private Double preco;
	private String cepDePernoite;
	public Integer getMarca() {
		return marca;
	}
	public void setMarca(Integer marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	public LocalDateTime getAno() {
		return ano;
	}
	public void setAno(LocalDateTime ano) {
		this.ano = ano;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getCepDePernoite() {
		return cepDePernoite;
	}
	public void setCepDePernoite(String cepDePernoite) {
		this.cepDePernoite = cepDePernoite;
	}

	
}
