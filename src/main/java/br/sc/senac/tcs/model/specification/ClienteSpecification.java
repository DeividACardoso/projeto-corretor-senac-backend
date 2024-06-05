package br.sc.senac.tcs.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.model.seletor.ClienteSeletor;
import jakarta.persistence.criteria.Predicate;

public class ClienteSpecification {

    public static Specification<Cliente> comFiltros(ClienteSeletor seletor) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (seletor.getNomeCliente() != null && !seletor.getNomeCliente().trim().isEmpty()) {
                predicates.add(cb.like(root.join("cliente").get("nome"), "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getNrCpf() != null && !seletor.getNrCpf().trim().isEmpty()) {
                predicates.add(cb.like(root.join("cpf").get("nome"), "%" + seletor.getNrCpf()));
            }
            if (seletor.getDtNascimento() != null && !seletor.getDtNascimento().toString().trim().isEmpty()) {
                predicates.add(cb.equal(root.get("dtNascimento"), seletor.getDtNascimento()));
                predicates.add(cb.lessThanOrEqualTo(root.get("dtNascimento"), seletor.getDtNascimento()));
            }

            if (seletor.getEnderecoEmail() != null && !seletor.getEnderecoEmail().trim().isEmpty()) {
                predicates.add(
                        cb.like(root.join("enderecoEmail").get("nome"), "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getNrCnh() != null && !seletor.getNrCnh().trim().isEmpty()) {
                predicates.add(cb.like(root.join("nrCnh").get("nome"), "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getNrTelefone() != null && !seletor.getNrTelefone().trim().isEmpty()) {
                predicates.add(
                        cb.like(root.join("nrTelefone").get("nome"), "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getSituacaoEstadoCivil() != null && !seletor.getSituacaoEstadoCivil().trim().isEmpty()) {
                predicates.add(cb.like(root.join("situacaoEstadoCivil").get("nome"),
                        "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getNomeGenero() != null && !seletor.getNomeGenero().trim().isEmpty()) {
                predicates.add(cb.like(root.join("nomeGenero").get("nome"),
                        "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getEnderecoRua() != null && !seletor.getEnderecoRua().trim().isEmpty()) {
                predicates.add(cb.like(root.join("enderecoRua").get("nome"),
                        "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getEnderecoBairro() != null && !seletor.getEnderecoBairro().trim().isEmpty()) {
                predicates.add(cb.like(root.join("enderecoBairro").get("nome"),
                        "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getEnderecoNr() != null && !seletor.getEnderecoNr().trim().isEmpty()) {
                predicates.add(cb.like(root.join("enderecoNr").get("nome"),
                        "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getEnderecoComplemento() != null && !seletor.getEnderecoComplemento().trim().isEmpty()) {
                predicates.add(cb.like(root.join("enderecoComplemento").get("nome"),
                        "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getEnderecoCidade() != null && !seletor.getEnderecoCidade().trim().isEmpty()) {
                predicates.add(cb.like(root.join("enderecoCidade").get("nome"),
                        "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getEnderecoUf() != null && !seletor.getEnderecoUf().trim().isEmpty()) {
                predicates.add(cb.like(root.join("enderecoUf").get("nome"),
                        "%" + seletor.getNomeCliente().toLowerCase()));
            }
            if (seletor.getCep() != null && !seletor.getCep().trim().isEmpty()) {
                predicates.add(cb.like(root.join("cep").get("nome"),
                        "%" + seletor.getNomeCliente().toLowerCase()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));

        };
    }
}
