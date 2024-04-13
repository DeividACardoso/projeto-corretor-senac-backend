package br.sc.senac.tcs.model.entidade;

import java.util.Date;
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
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;
    private String cpf;
    
    @Column(name = "dt_nascimento", nullable = false, columnDefinition = "DATE")
    private Date dtNascimento;
    
    private String email;
    private String cnh;
    private String ddd;
    private String telefone;
   
    @Column(name = "estado_civil", nullable = false, columnDefinition = "VARCHAR(30)")
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
    @JoinColumn(name = "corretor_id", nullable = false, columnDefinition = "INT")
    private Corretor corretor;
    
    @JsonBackReference
    @OneToMany(mappedBy = "cliente")
    private List<Seguro> seguros;
}