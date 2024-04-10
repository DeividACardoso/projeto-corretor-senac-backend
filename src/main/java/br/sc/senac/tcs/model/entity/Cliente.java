package br.sc.senac.tcs.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "clientes")
@EqualsAndHashCode(callSuper=false)
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(length = 255, nullable = false)
    private int id;

    @Column(length = 255, nullable = false)
    private String cnh;

    @Column(length = 255, nullable = false)
    private String ddd;

    @Column(length = 255, nullable = false)
    private String telefone;

    @Column(nullable = false)
    private int idEndereco;

    @Column(length = 255, nullable = false)
    private String estadoCivil;

    @Column(length = 255, nullable = false)
    private String genero;

    @OneToMany(mappedBy = "cliente")
    private List<Corretor> seguros;

    @OneToMany(mappedBy = "cliente")
    private List<Veiculo> veiculos;

    public String getCnh() {
        return this.cnh;
    }

    @Override
    public void operation1() {  
        throw new UnsupportedOperationException("Unimplemented method 'operation1'");
    }

    @Override
    protected void operation2() {
        throw new UnsupportedOperationException("Unimplemented method 'operation2'");
    }

    @Override
    protected void operation3() {
        throw new UnsupportedOperationException("Unimplemented method 'operation3'");
    }
    
}
