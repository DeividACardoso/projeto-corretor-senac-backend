package br.sc.senac.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcsApplication.class, args);
    }
//
//    @Bean
//    public CommandLineRunner runner() {
//        return args -> {
//            List<Cliente> clientes = Arrays.asList(
//                new Cliente("Nome1", 12345678901L, new Date(), "email1@example.com", "cnh1", "ddd1", "telefone1", "estadoCivil1", "genero1", "rua1", "bairro1", null),
//   			    new Cliente("Nome2", 12345678902L, new Date(), "email2@example.com", "cnh2", "ddd2", "telefone2", "estadoCivil2", "genero2", "rua2", "bairro2", null),
//                new Cliente("Nome3", 12345678903L, new Date(), "email3@example.com", "cnh3", "ddd3", "telefone3", "estadoCivil3", "genero3", "rua3", "bairro3", null),
//                new Cliente("Nome4", 12345678904L, new Date(), "email4@example.com", "cnh4", "ddd4", "telefone4", "estadoCivil4", "genero4", "rua4", "bairro4", null),
//                new Cliente("Nome5", 12345678905L, new Date(), "email5@example.com", "cnh5", "ddd5", "telefone5", "estadoCivil5", "genero5", "rua5", "bairro5", null)
//);
//
//            clientes.forEach(System.out::println);
//        };
//    }

}
