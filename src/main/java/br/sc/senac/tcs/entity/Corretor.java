package br.sc.senac.tcs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "corretores")
public class Corretor extends Pessoa {

    @Column(length = 255, nullable = false)
    private String senha;

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
