package br.sc.senac.tcs.model.entidade;

import java.time.LocalDate;

import br.sc.senac.tcs.model.dto.SeguroDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seguro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "seguradora_id")
	private Seguradora seguradora;

	@ManyToOne
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

	public Seguro(Seguradora seguradora, Veiculo veiculo, Cliente cliente, String numeroProposta,
			String numApolice, double rcfDanosMateriais, double rofDanosFisicos, LocalDate dtInicioVigencia,
			LocalDate dtFimVigencia, double franquia, boolean carroReserva, boolean ativo) {
	}
}
