package br.sc.senac.tcs.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.tcs.model.entidade.Veiculo;
import br.sc.senac.tcs.model.seletor.VeiculoSeletor;
import jakarta.persistence.criteria.Predicate;

public class VeiculoSpecification {

	public static Specification<Veiculo> comFiltros(VeiculoSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			 	if (seletor.getMarca() != null && seletor.getMarca() != null) {
			      predicates.add(cb.between(root.get("marca"), seletor.getMarca(), seletor.getMarca()));
			    }

			    if (seletor.getModelo() != null && seletor.getModelo() != null) {
			      predicates.add(cb.between(root.get("modelo"), seletor.getModelo(), seletor.getModelo()));
			    }

			    if (seletor.getAno() != null && seletor.getAno() != null) {
			      predicates.add(cb.between(root.get("ano"), seletor.getAno(), seletor.getAno()));
			    }

			    if (seletor.getNomeCliente() != null && seletor.getNomeCliente() != null) {
				      predicates.add(cb.between(root.get("cliente"), seletor.getNomeCliente(), seletor.getNomeCliente()));
				    }
			    
			return cb.and(predicates.toArray(new Predicate[0]));

		};
	}
	
}
