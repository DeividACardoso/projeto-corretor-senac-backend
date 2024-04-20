package br.sc.senac.tcs.model.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(length = 255, nullable = false)
	private int id;

	@Column(length = 255, nullable = false)
	private String nome;

	@Column(length = 11, nullable = false)
	private String cpf;

	@Column(nullable = false)
	@jakarta.persistence.Temporal(jakarta.persistence.TemporalType.DATE)
	private Date dtNascimento;

	@Column(length = 255, nullable = false)
	private String email;

	@Column(length = 255, nullable = false)
	private String cnh;

	@Column(length = 255, nullable = false)
	private String ddd;

	@Column(length = 255, nullable = false)
	private String telefone;

	@Column(length = 255, nullable = false)
	private String estadoCivil;

	@Column(length = 255, nullable = false)
	private String genero;

	@Column(length = 255, nullable = false)
	private String rua;

	@Column(length = 255, nullable = false)
	private String bairro;

	@ManyToOne
	@JoinColumn(name = "corretor_id")
	private Corretor corretor;

	public Cliente(String nome, String cpf, Date dtNascimento, String email, String cnh, String ddd, String telefone,
			String estadoCivil, String genero, String rua, String bairro, Corretor corretor) {
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.email = email;
		this.cnh = cnh;
		this.ddd = ddd;
		this.telefone = telefone;
		this.estadoCivil = estadoCivil;
		this.genero = genero;
		this.rua = rua;
		this.bairro = bairro;
		this.corretor = corretor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Corretor getCorretor() {
		return corretor;
	}

	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}

}
