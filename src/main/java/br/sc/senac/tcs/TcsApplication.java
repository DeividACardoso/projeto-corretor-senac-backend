package br.sc.senac.tcs;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.sc.senac.tcs.model.entidade.Cliente;

@SpringBootApplication
public class TcsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcsApplication.class, args);
    }


}
