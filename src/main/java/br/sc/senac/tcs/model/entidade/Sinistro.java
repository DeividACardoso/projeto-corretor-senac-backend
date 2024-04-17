package br.sc.senac.tcs.model.entidade;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sinistro")
@NoArgsConstructor
@Data
public class Sinistro {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String codigo;
	private String tipo;
	private String descricao;

//    @ManyToMany(mappedBy = "seguro")
//    private List<Seguro> seguros;

	public Sinistro(int id, String codigo, String tipo, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.tipo = tipo;
		this.descricao = descricao;
//		this.seguros = seguros;
	}
    
    
	
	
}
