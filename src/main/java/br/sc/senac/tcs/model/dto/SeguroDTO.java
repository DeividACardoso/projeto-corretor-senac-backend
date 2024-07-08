package br.sc.senac.tcs.model.dto;

import java.time.LocalDate;

import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.model.entidade.Seguradora;
import br.sc.senac.tcs.model.entidade.Veiculo;

public record SeguroDTO(
Cliente cliente,
Veiculo veiculo,
Seguradora seguradora,
LocalDate dataInicio,
LocalDate dataFim,
String numeroProposta,
String numeroApolice,
boolean ativo)
{

}
