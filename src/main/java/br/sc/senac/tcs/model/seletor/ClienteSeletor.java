package br.sc.senac.tcs.model.seletor;

import java.time.LocalDate;

public class ClienteSeletor extends BaseSeletor {

    private String nomeCliente;
    private String cpf;
    private LocalDate dtNascimentoInicio;
    private LocalDate dtNascimentoFim;
    private String enderecoEmail;
    private String cnh;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtNascimentoInicio() {
        return dtNascimentoInicio;
    }

    public void setDtNascimentoInicio(LocalDate dtNascimentoInicio) {
        this.dtNascimentoInicio = dtNascimentoInicio;
    }

    public LocalDate getDtNascimentoFim() {
        return dtNascimentoFim;
    }

    public void setDtNascimentoFim(LocalDate dtNascimentoFim) {
        this.dtNascimentoFim = dtNascimentoFim;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }


}
