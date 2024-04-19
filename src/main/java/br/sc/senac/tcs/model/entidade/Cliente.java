package br.sc.senac.tcs.model.entidade;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;
    private String cpf;
    @Column(nullable = false)
    private LocalDate dtNascimento;

    @Column(length = 255, nullable = false)
    private String email;
    private String cnh;
    private String ddd;
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
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "corretor_id", nullable = false, columnDefinition = "INT")
    private Corretor corretor;
    
    @JsonBackReference
    @OneToMany(mappedBy = "cliente")
    private List<Seguro> seguros;

//
//    public Cliente(String nome, String cpf, LocalDate dtNascimento, String email, String cnh, String ddd, String telefone,
//            String estadoCivil, String genero, String rua, String bairro, Corretor corretor) {
//        this.nome = nome;
//        this.cpf = cpf;
//        this.dtNascimento = dtNascimento;
//        this.email = email;
//        this.cnh = cnh;
//        this.ddd = ddd;
//        this.telefone = telefone;
//        this.estadoCivil = estadoCivil;
//        this.genero = genero;
//        this.rua = rua;
//        this.bairro = bairro;
//        this.corretor = corretor;
//    }

}
