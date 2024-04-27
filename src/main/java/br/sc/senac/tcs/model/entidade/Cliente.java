package br.sc.senac.tcs.model.entidade;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(length = 255, nullable = false)
	private int id;
    
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
    @Column(name = "corretor_id")
    private Integer idCorretor;
    
    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Seguro> seguros;
}
