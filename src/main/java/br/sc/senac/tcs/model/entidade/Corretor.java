package br.sc.senac.tcs.model.entidade;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class Corretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String codigo;
    private String ddd;
    private String telefone;
    private String email;
    private String senha;
    
    @JsonBackReference
    @OneToMany(mappedBy = "corretor")
    private List<Cliente> clientes;
    
	public Corretor(Integer id, String nome, String cpf, String codigo, String ddd, String telefone, String email,
		String senha, List<Cliente> clientes) {
	super();
	this.id = id;
	this.nome = nome;
	this.cpf = cpf;
	this.codigo = codigo;
	this.ddd = ddd;
	this.telefone = telefone;
	this.email = email;
	this.senha = senha;
	this.clientes = clientes;
}
	public Corretor() {
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
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
    
}
