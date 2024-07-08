package br.sc.senac.tcs.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.tcs.model.entidade.Sinistro;
import br.sc.senac.tcs.model.seletor.SinistroSeletor;
import jakarta.persistence.criteria.Predicate;

public class SinistroSpecification {

	public static Specification<Sinistro> comFiltros(SinistroSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (seletor.getTipo() != null && !seletor.getTipo().trim().isEmpty()) {
				predicates.add(cb.equal(root.get("tipo"), seletor.getTipo().toLowerCase()));
			}

			if (seletor.getDataInicial() != null && seletor.getDataFinal() != null) {
				predicates.add(cb.between(root.get("dataInicial"), seletor.getDataInicial(), seletor.getDataFinal()));
			} else if (seletor.getDataInicial() != null) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("dataInicial"), seletor.getDataInicial()));
			} else if (seletor.getDataFinal() != null) {
				predicates.add(cb.lessThanOrEqualTo(root.get("dataInicial"), seletor.getDataFinal()));
			}

			if (seletor.getHorarioInicial() != null && seletor.getHorarioFinal() != null) {
				predicates.add(
						cb.between(root.get("horarioInicial"), seletor.getHorarioInicial(), seletor.getHorarioFinal()));
			} else if (seletor.getHorarioInicial() != null) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("horarioInicial"), seletor.getHorarioInicial()));
			} else if (seletor.getHorarioFinal() != null) {
				predicates.add(cb.lessThanOrEqualTo(root.get("horarioInicial"), seletor.getHorarioFinal()));
			}

			if (seletor.getDescricao() != null && !seletor.getDescricao().trim().isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("descricao")),
						"%" + seletor.getDescricao().trim().toLowerCase() + "%"));
			}

			return cb.and(predicates.toArray(new Predicate[0]));

		};
	}

}
