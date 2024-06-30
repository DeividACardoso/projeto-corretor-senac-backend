package br.sc.senac.tcs.model.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;

public record ClienteDTO(
        String nome,
        String cpf,
        LocalDate dtNascimento,
        String email,
        String cnh,
        String telefone,
        String estadoCivil,
        String genero,
        String rua,
        String bairro,
        String numero,
        String complemento,
        String cidade,
        String uf,
        String cep) {

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getCnh() {
        return cnh;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getGenero() {
        return genero;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

}
