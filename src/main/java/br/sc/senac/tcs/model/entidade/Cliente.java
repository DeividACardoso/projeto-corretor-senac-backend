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
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nome;
    @Column(name = "cpf", nullable = false, columnDefinition = "VARCHAR(11)")
    private String cpf;
    @Column(name = "dt_nascimento", nullable = false, columnDefinition = "DATE")
    private Date dtNascimento;
    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(100)")
    private String email;
    @Column(name = "cnh", nullable = false, columnDefinition = "VARCHAR(9)")
    private String cnh;
    @Column(name = "ddd", nullable = false, columnDefinition = "VARCHAR(3)")
    private String ddd;
    @Column(name = "telefone", nullable = false, columnDefinition = "VARCHAR(9)")
    private String telefone;
    @Column(name = "estado_civil", nullable = false, columnDefinition = "VARCHAR(30)")
    private String estadoCivil;
    @Column(name = "genero", nullable = false, columnDefinition = "VARCHAR(30)")
    private String genero;
    @Column(name = "rua", nullable = false, columnDefinition = "VARCHAR(100)")
    private String rua;
    @Column(name = "bairro", nullable = false, columnDefinition = "VARCHAR(100)")
    private String bairro;
    @Column(name = "numero", nullable = false, columnDefinition = "VARCHAR(100)")
    private String numero;
    @Column(name = "complemento", nullable = false, columnDefinition = "VARCHAR(100)")
    private String complemento;
    @Column(name = "cidade", nullable = false, columnDefinition = "VARCHAR(100)")
    private String cidade;
    @Column(name = "uf", nullable = false, columnDefinition = "VARCHAR(2)")
    private String uf;
    @Column(name = "cep", nullable = false, columnDefinition = "VARCHAR(8)")
    private String cep;
    @ManyToOne
    @JoinColumn(name = "corretor_id", nullable = false, columnDefinition = "INT")
    private Corretor corretor;
    
	public Cliente(Integer id, String nome, String cpf, Date dtNascimento, String email, String cnh, String ddd,
		String telefone, String estadoCivil, String genero, String rua, String bairro, String numero,
		String complemento, String cidade, String uf, String cep, Corretor corretor) {
	super();
	this.id = id;
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
	this.numero = numero;
	this.complemento = complemento;
	this.cidade = cidade;
	this.uf = uf;
	this.cep = cep;
	this.corretor = corretor;
}
	public Cliente() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Corretor getCorretor() {
		return corretor;
	}
	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
    
	

}