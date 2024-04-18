package br.sc.senac.tcs.model.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Integer id;
	private String codigo;
	private String tipo;
	private String descricao;
	
	public Sinistro(Integer id, String codigo, String tipo, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	
    
	
	
}
