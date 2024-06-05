package br.sc.senac.tcs.model.seletor;

import java.time.LocalDate;

public class ClienteSeletor extends BaseSeletor {

    private String nomeCliente;
    private String nrCpf;
    private LocalDate dtNascimento;
    private String enderecoEmail;
    private String nrCnh;
    private String nrTelefone;
    private String situacaoEstadoCivil;
    private String nomeGenero;
    private String enderecoRua;
    private String enderecoBairro;
    private String enderecoNr;
    private String enderecoComplemento;
    private String enderecoCidade;
    private String enderecoUf;
    private String cep;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public String getNrCnh() {
        return nrCnh;
    }

    public void setNrCnh(String nrCnh) {
        this.nrCnh = nrCnh;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public String getSituacaoEstadoCivil() {
        return situacaoEstadoCivil;
    }

    public void setSituacaoEstadoCivil(String situacaoEstadoCivil) {
        this.situacaoEstadoCivil = situacaoEstadoCivil;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoNr() {
        return enderecoNr;
    }

    public void setEnderecoNr(String enderecoNr) {
        this.enderecoNr = enderecoNr;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoUf() {
        return enderecoUf;
    }

    public void setEnderecoUf(String enderecoUf) {
        this.enderecoUf = enderecoUf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
