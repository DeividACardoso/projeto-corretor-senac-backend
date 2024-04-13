package br.sc.senac.tcs.model.entidade;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "corretores")
public class Corretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "corretor")
    private List<Cliente> clientes;

}
