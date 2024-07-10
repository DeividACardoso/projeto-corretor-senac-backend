package br.sc.senac.tcs.model.entidade;

import java.time.LocalDate;
import br.sc.senac.tcs.model.dto.ClienteDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cpf;

    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;
    private String email;
    private String cnh;
    private String telefone;
    @Column(name = "estado_civil")
    private String estadoCivil;
    private String genero;
    private String rua;
    private String bairro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;

    public Cliente(ClienteDTO clienteDTO) {
        this.nome = clienteDTO.getNome();
        this.cpf = clienteDTO.getCpf();
        this.dtNascimento = clienteDTO.getDtNascimento();
        this.email = clienteDTO.getEmail();
        this.cnh = clienteDTO.getCnh();
        this.telefone = clienteDTO.getTelefone();
        this.estadoCivil = clienteDTO.getEstadoCivil();
        this.genero = clienteDTO.getGenero();
        this.rua = clienteDTO.getRua();
        this.bairro = clienteDTO.getBairro();
        this.numero = clienteDTO.getNumero();
        this.complemento = clienteDTO.getComplemento();
        this.cidade = clienteDTO.getCidade();
        this.uf = clienteDTO.getUf();
        this.cep = clienteDTO.getCep();
    }

    public Cliente(String nome, String cpf, LocalDate dtNascimento, String email, String cnh, String telefone,
            String estadoCivil, String genero, String rua, String bairro, String numero, String complemento, String cidade,
            String uf, String cep) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.email = email;
        this.cnh = cnh;
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
    }
}
