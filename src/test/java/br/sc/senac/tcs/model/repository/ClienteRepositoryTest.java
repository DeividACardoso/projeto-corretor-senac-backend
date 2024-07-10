package br.sc.senac.tcs.model.repository;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.sc.senac.tcs.model.dto.ClienteDTO;
import br.sc.senac.tcs.model.entidade.Cliente;
import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class ClienteRepositoryTest {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Deve retornar verdadeiro se existir um cliente com o Email informado")
    void testFindByEmailCase1() {
        LocalDate dataNascimento = LocalDate.of(1999, 9, 5);
        String email = "teste@gmail.com";
        ClienteDTO data = new ClienteDTO("Teste", "23164598712", dataNascimento, email,
                "23184897", "48984700912", "Solteiro", "Masc",
                "Das frô", "monte verde", "74", "Casa", "Floripa", "SC", "SC");
        this.criarCliente(data);

        Optional<Cliente> result = this.clienteRepository.findByEmail(email);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Deve retornar true se não existir um cliente com o Email informado")
    void testFindByEmailCase2() {
        String email = "teste@gmail.com";

        Optional<Cliente> result = this.clienteRepository.findByEmail(email);
        assertThat(result.isEmpty()).isTrue();
    }

    private Cliente criarCliente(ClienteDTO data) {
        Cliente cliente = new Cliente(data);
        this.entityManager.persist(cliente);
        this.entityManager.flush();
        return cliente;
    }
}
