package br.sc.senac.tcs.model.entidade;

import java.time.LocalDate;

import br.sc.senac.tcs.model.dto.SeguroDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Seguro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "seguradora_id")
	private Seguradora seguradora;

	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	private String numeroProposta;
	private String numApolice;
	private double rcfDanosMateriais;
	private double rofDanosFisicos;
	private LocalDate dtInicioVigencia;
	private LocalDate dtFimVigencia;
	private double franquia;
	private boolean carroReserva;
	private boolean ativo;
	
	public Seguro(SeguroDTO data) {
	}
}
