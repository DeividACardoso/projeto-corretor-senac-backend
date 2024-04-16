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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(length = 255, nullable = false)
    private int id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 11, nullable = false)
    private int cpf;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
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

}
