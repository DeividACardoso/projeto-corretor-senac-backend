package br.sc.senac.tcs.model.entidade;


public record RegisterDTO(
    String email,
    String senha,
    String nome,
    String cpf,
    String telefone
) {}
