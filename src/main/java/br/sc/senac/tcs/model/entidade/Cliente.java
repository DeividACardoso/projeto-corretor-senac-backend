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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Data
@Getter
@Setter
@RequiredArgsConstructor
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
    @JoinColumn(name = "corretor_id")
    private Corretor corretor;
    
    @OneToMany
    @JoinColumn(name = "cliente")
    private List<Veiculo> veiculos;
    
    @JsonBackReference
    @OneToMany(mappedBy = "cliente")
    private List<Seguro> seguros;


}
