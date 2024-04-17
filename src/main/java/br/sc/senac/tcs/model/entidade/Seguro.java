package br.sc.senac.tcs.model.entidade;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy.Eager;

@Entity
@Table
@Data
public class Seguro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// private Seguradora idSeguradora;
	private int seguradoraId;
	//private Veiculo veiculo;
	private int veiculoId;
	
	@ManyToOne
	// @JsonBackReference("corretor")
    @JoinColumn(name = "corretor_id")
	private Corretor corretor;
	
	@ManyToOne()
	// @JsonBackReference("cliente")
    @JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private double rcfDanosMateriais;
	private double rofDanosFisicos;
	private LocalDate dtInicioVigencia;
	private LocalDate dtFimVigencia;
	private String numeroProposta;
	private double franquia;
	private boolean carroReserva;
	private String numApolice;
	private String nome;
}
