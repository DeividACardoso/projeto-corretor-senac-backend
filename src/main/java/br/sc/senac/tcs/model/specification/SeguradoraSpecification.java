package br.sc.senac.tcs.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.tcs.model.entidade.Seguradora;
import br.sc.senac.tcs.model.seletor.SeguradoraSeletor;
import jakarta.persistence.criteria.Predicate;

public class SeguradoraSpecification {

	public static Specification<Seguradora> comFiltros(SeguradoraSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (seletor.getNome() != null && !seletor.getNome().toString().trim().isEmpty()) {
				predicates.add(cb.like(root.get("nome"), "%" + seletor.getNome().toLowerCase()));
			}

			if (seletor.getCnpj() != null && !seletor.getCnpj().toString().trim().isEmpty()) {
				predicates.add(cb.like(root.get("cnpj"), "%" + seletor.getCnpj().toLowerCase()));
			}

			if (seletor.getDdd() != null && !seletor.getDdd().toString().trim().isEmpty()) {
				predicates.add(cb.like(root.get("ddd"), "%" + seletor.getDdd().toLowerCase()));
			}

			if (seletor.getTelefone() != null && !seletor.getTelefone().toString().trim().isEmpty()) {
				predicates.add(cb.like(root.get("telefone"), "%" + seletor.getTelefone().toLowerCase()));
			}

			if (seletor.getEmail() != null && !seletor.getEmail().toString().trim().isEmpty()) {
				predicates.add(cb.like(root.get("email"), "%" + seletor.getEmail().toLowerCase()));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

}
