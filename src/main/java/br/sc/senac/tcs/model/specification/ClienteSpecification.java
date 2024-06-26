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
                predicates.add(cb.like(root.get("nome"), "%" + seletor.getNomeCliente().toLowerCase() + "%"));
            }
            if (seletor.getCpf() != null && !seletor.getCpf().trim().isEmpty()) {
                predicates.add(cb.like(root.get("cpf"), "%" + seletor.getCpf() + "%"));
            }
			if(seletor.getDtNascimentoInicio() != null && !seletor.getDtNascimentoInicio().toString().trim().isEmpty() 
					&& seletor.getDtNascimentoFim() != null && !seletor.getDtNascimentoFim().toString().trim().isEmpty()) { //Filtro para periodo de data de Inicio vigência
				predicates.add(cb.between(root.get("dtNascimento"), seletor.getDtNascimentoInicio(), seletor.getDtNascimentoFim()));
			} else if(seletor.getDtNascimentoInicio() != null && !seletor.getDtNascimentoInicio().toString().trim().isEmpty()){ //Filtro para data inicio de vigência maior que data inserida(se maior, ainda não vigente)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dtNascimento"), seletor.getDtNascimentoInicio()));
			} else if(seletor.getDtNascimentoFim() != null && !seletor.getDtNascimentoFim().toString().trim().isEmpty()) { //Filtro para data inicio de vigência menor que a data inserida(se menor, vigente) 
				predicates.add(cb.lessThanOrEqualTo(root.get("dtNascimento"), seletor.getDtNascimentoFim()));
			}

            if (seletor.getEnderecoEmail() != null && !seletor.getEnderecoEmail().trim().isEmpty()) {
                predicates.add(
                        cb.like(root.get("email"), "%" + seletor.getEnderecoEmail().toLowerCase() + "%"));
            }
            if (seletor.getCnh() != null && !seletor.getCnh().trim().isEmpty()) {
                predicates.add(cb.like(root.get("cnh"), "%" + seletor.getCnh() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));

        };
    }
}
