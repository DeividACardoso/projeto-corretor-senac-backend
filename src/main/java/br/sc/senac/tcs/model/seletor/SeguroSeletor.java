package br.sc.senac.tcs.model.seletor;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SeguroSeletor extends BaseSeletor {

	private String nomeSeguradora;
	private String nomeCliente;
	private LocalDate dtInicioComecoVigencia;
	private LocalDate dtFimComecoVigencia;
	private LocalDate dtInicioFimVigencia;
	private LocalDate dtFimFimVigencia;
	private Double menorRcfDanosMateriais;
	private Double maiorRcfDanosMateriais;
	private Double menorRofDanosFisicos;
	private Double maiorRofDanosFisicos;
	private Double menorFranquia;
	private Double maiorFranquia;
	private Boolean carroReserva;

}
