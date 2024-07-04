package br.sc.senac.tcs.model.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "veiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String preco;
	private String marca;
	private String modelo;
	private int anoModelo;
	private String tipoCombustivel;
	private String rua;
	private String bairro;
	private String complemento;
	private int numero;
	private String cidade;
	private String uf;
	private String cep;
	private String placa;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Veiculo(String preco, String marca, String modelo, int anoModelo, String tipoCombustivel, String rua,
			String bairro, String complemento, int numero, String cidade, String uf, String cep, String placa,
			Cliente cliente) {
		super();
		this.preco = preco;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.tipoCombustivel = tipoCombustivel;
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.numero = numero;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.placa = placa;
		this.cliente = cliente;
	}

}

