package br.sc.senac.tcs.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.seletor.SeguroSeletor;
import jakarta.persistence.criteria.Predicate;

public class SeguroSpecification {
	
	public static Specification<Seguro> comFiltros(SeguroSeletor seletor){
		return (root, query, cb) ->{
			List<Predicate> predicates = new ArrayList<>();
			
			if(seletor.getNomeSeguradora() != null && !seletor.getNomeSeguradora().trim().isEmpty()) {
				predicates.add(cb.like(root.join("seguradora").get("nome"), "%" + seletor.getNomeSeguradora().toLowerCase() + "%"));
			}
			if(seletor.getNomeCliente() != null && !seletor.getNomeCliente().toString().trim().isEmpty()) {
				predicates.add(cb.like(root.join("cliente").get("nome"), "%" + seletor.getNomeCliente().toLowerCase() + "%"));
			}
			//Filtros de inicio da vigência
			if(seletor.getDtInicioComecoVigencia() != null && !seletor.getDtInicioComecoVigencia().toString().trim().isEmpty() 
					&& seletor.getDtFimComecoVigencia() != null && !seletor.getDtFimComecoVigencia().toString().trim().isEmpty()) { //Filtro para periodo de data de Inicio vigência
				predicates.add(cb.between(root.get("dtInicioVigencia"), seletor.getDtInicioComecoVigencia(), seletor.getDtFimComecoVigencia()));
			} else if(seletor.getDtInicioComecoVigencia() != null && !seletor.getDtInicioComecoVigencia().toString().trim().isEmpty()){ //Filtro para data inicio de vigência maior que data inserida(se maior, ainda não vigente)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dtInicioVigencia"), seletor.getDtInicioComecoVigencia()));
			} else if(seletor.getDtFimComecoVigencia() != null && !seletor.getDtFimComecoVigencia().toString().trim().isEmpty()) { //Filtro para data inicio de vigência menor que a data inserida(se menor, vigente) 
				predicates.add(cb.lessThanOrEqualTo(root.get("dtInicioVigencia"), seletor.getDtFimComecoVigencia()));
			}
			//Filtros de fim da vigência
			if(seletor.getDtInicioFimVigencia() != null && !seletor.getDtInicioFimVigencia().toString().trim().isEmpty() 
					&& seletor.getDtFimFimVigencia() != null && !seletor.getDtFimFimVigencia().toString().trim().isEmpty()) { //Filtro para periodo de data de Fim vigência
				predicates.add(cb.between(root.get("dtFimVigencia"), seletor.getDtInicioFimVigencia(), seletor.getDtFimFimVigencia()));
			} else if(seletor.getDtInicioFimVigencia() != null && !seletor.getDtInicioFimVigencia().toString().trim().isEmpty()){ //Filtro para data fim de vigência maior que data inserida(se maior, ainda vigente)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dtFimVigencia"), seletor.getDtInicioFimVigencia()));
			} else if(seletor.getDtFimFimVigencia() != null && !seletor.getDtFimFimVigencia().toString().trim().isEmpty()) { //Filtro para data fim de vigência menor que a data inserida (se menor, não mais vigente) 
				predicates.add(cb.lessThanOrEqualTo(root.get("dtFimVigencia"), seletor.getDtFimFimVigencia()));
			}
			
			if(seletor.getMenorRcfDanosMateriais() != null && !seletor.getMenorRcfDanosMateriais().toString().trim().isEmpty()
					&& seletor.getMaiorRcfDanosMateriais() != null && seletor.getMaiorRcfDanosMateriais().toString().trim().isEmpty()) {
				predicates.add(cb.between(root.get("rcfDanosMateriais"), seletor.getMenorRcfDanosMateriais(), seletor.getMaiorRcfDanosMateriais()));
			} else if(seletor.getMenorRcfDanosMateriais() != null && !seletor.getMenorRcfDanosMateriais().toString().trim().isEmpty()) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("rcfDanosMateriais"), seletor.getMenorRcfDanosMateriais()));
			} else if(seletor.getMaiorRcfDanosMateriais() != null && !seletor.getMaiorRcfDanosMateriais().toString().trim().isEmpty()) {
				predicates.add(cb.lessThanOrEqualTo(root.get("rcfDanosMateriais"), seletor.getMaiorRcfDanosMateriais()));
			}
			
			if(seletor.getMenorRofDanosFisicos() != null && !seletor.getMenorRofDanosFisicos().toString().trim().isEmpty()
					&& seletor.getMaiorRofDanosFisicos() != null && seletor.getMaiorRofDanosFisicos().toString().trim().isEmpty()) {
				predicates.add(cb.between(root.get("rofDanosFisicos"), seletor.getMenorRofDanosFisicos(), seletor.getMaiorRofDanosFisicos()));
			} else if(seletor.getMenorRofDanosFisicos() != null && !seletor.getMenorRofDanosFisicos().toString().trim().isEmpty()) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("rofDanosFisicos"), seletor.getMenorRofDanosFisicos()));
			} else if(seletor.getMaiorRofDanosFisicos() != null && !seletor.getMaiorRofDanosFisicos().toString().trim().isEmpty()) {
				predicates.add(cb.lessThanOrEqualTo(root.get("rofDanosFisicos"), seletor.getMaiorRofDanosFisicos()));
			}
			
			if(seletor.getMenorFranquia() != null && !seletor.getMenorFranquia().toString().trim().isEmpty()
					&& seletor.getMaiorFranquia() != null && seletor.getMaiorFranquia().toString().trim().isEmpty()) {
				predicates.add(cb.between(root.get("franquia"), seletor.getMenorFranquia(), seletor.getMaiorFranquia()));
			} else if(seletor.getMenorFranquia() != null && !seletor.getMenorFranquia().toString().trim().isEmpty()) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("franquia"), seletor.getMenorFranquia()));
			} else if(seletor.getMaiorFranquia() != null && !seletor.getMaiorFranquia().toString().trim().isEmpty()) {
				predicates.add(cb.lessThanOrEqualTo(root.get("franquia"), seletor.getMaiorFranquia()));
			}
			
			if(seletor.getCarroReserva() != null && !seletor.getCarroReserva().toString().trim().isEmpty()) {
				predicates.add(cb.like(root.get("carroReserva"), "%" + seletor.getCarroReserva().toLowerCase()));
			}
			
		return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
