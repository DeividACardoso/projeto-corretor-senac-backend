package br.sc.senac.tcs.model.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.model.entidade.Seguradora;
import br.sc.senac.tcs.model.entidade.Seguro;
import br.sc.senac.tcs.model.entidade.Veiculo;
import jakarta.transaction.Transactional;

@DataJpaTest
@ActiveProfiles("test")
public class SeguroRepositoryTest {

    @Autowired
    SeguroRepository seguroRepository;

    @Autowired
    SeguradoraRepository seguradoraRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    @Test
    void testFindAll() {
        Seguradora seguradora = new Seguradora(
                "Seguradora Teste",
                "12345678900",
                "segteste@gmail.com",
                "4894700981");
        Cliente cliente = new Cliente(
                "João da Silva",
                "123.456.789-00",
                LocalDate.of(1990, 1, 15),
                "joao.silva@example.com",
                "12345678900",
                "(11) 98765-4321",
                "Solteiro",
                "Masculino",
                "Avenida Brasil",
                "Centro",
                "1000",
                "Apto 101",
                "São Paulo",
                "SP",
                "12345-678");
        Veiculo veiculo = new Veiculo(
                "50000",
                "Toyota",
                "Corolla",
                2020,
                "Gasolina",
                "Rua das Flores",
                "Centro",
                "Apt 101",
                123,
                "São Paulo",
                "SP",
                "12345678",
                "ABC1234",
                cliente);
        Seguro seguro = new Seguro(
                seguradora,
                veiculo,
                cliente,
                "123456",
                "ABC123456789",
                50000.00,
                100000.00,
                LocalDate.of(2024, 7, 1),
                LocalDate.of(2025, 6, 30),
                1500.00,
                true,
                true);

        this.seguradoraRepository.save(seguradora);
        this.clienteRepository.save(cliente);
        this.veiculoRepository.save(veiculo);
        this.seguroRepository.save(seguro);

        List<Seguro> result = this.seguroRepository.findAll();

        assertThat(result.isEmpty()).isFalse();
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    @Transactional
    void testFindAllByClienteId() {
        Seguradora seguradora = new Seguradora(
                null,
                "Seguradora Teste",
                "12345678900",
                "segteste@gmail.com",
                "4894700981");
        Cliente cliente = new Cliente(
                null,
                "João da Silva",
                "123.456.789-00",
                LocalDate.of(1990, 1, 15),
                "joao.silva@example.com",
                "12345678900",
                "(11) 98765-4321",
                "Solteiro",
                "Masculino",
                "Avenida Brasil",
                "Centro",
                "1000",
                "Apto 101",
                "São Paulo",
                "SP",
                "12345-678");
        Veiculo veiculo = new Veiculo(
                null,
                "50000",
                "Toyota",
                "Corolla",
                2020,
                "Gasolina",
                "Rua das Flores",
                "Centro",
                "Apt 101",
                123,
                "São Paulo",
                "SP",
                "12345678",
                "ABC1234",
                cliente);
        Seguro seguro1 = new Seguro(
                null,
                seguradora,
                veiculo,
                cliente,
                "123456",
                "ABC123456789",
                50000.00,
                100000.00,
                LocalDate.of(2024, 7, 1),
                LocalDate.of(2025, 6, 30),
                1500.00,
                true,
                true);
        Seguro seguro2 = new Seguro(
                null,
                seguradora,
                veiculo,
                cliente,
                "654321",
                "DEF987654321",
                30000.00,
                60000.00,
                LocalDate.of(2023, 5, 1),
                LocalDate.of(2024, 4, 30),
                1200.00,
                false,
                false);

        this.seguradoraRepository.save(seguradora);
        this.clienteRepository.save(cliente);
        this.veiculoRepository.save(veiculo);
        this.seguroRepository.save(seguro1);
        this.seguroRepository.save(seguro2);

        List<Seguro> result = this.seguroRepository.findAllByClienteId(cliente.getId());

        assertThat(result.isEmpty()).isFalse();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void testFindAllByVeiculoId() {
        Seguradora seguradora = new Seguradora(
                null,
                "Seguradora Teste",
                "12345678900",
                "segteste@gmail.com",
                "4894700981");
        Cliente cliente = new Cliente(
                null,
                "João da Silva",
                "123.456.789-00",
                LocalDate.of(1990, 1, 15),
                "joao.silva@example.com",
                "12345678900",
                "(11) 98765-4321",
                "Solteiro",
                "Masculino",
                "Avenida Brasil",
                "Centro",
                "1000",
                "Apto 101",
                "São Paulo",
                "SP",
                "12345-678");
        Veiculo veiculo1 = new Veiculo(
                null,
                "50000",
                "Toyota",
                "Corolla",
                2020,
                "Gasolina",
                "Rua das Flores",
                "Centro",
                "Apt 101",
                123,
                "São Paulo",
                "SP",
                "12345678",
                "ABC1234",
                cliente);
        Veiculo veiculo2 = new Veiculo(
                null,
                "40000",
                "Honda",
                "Civic",
                2019,
                "Gasolina",
                "Rua dos Carros",
                "Centro",
                "Apt 102",
                456,
                "São Paulo",
                "SP",
                "87654321",
                "DEF5678",
                cliente);
        Seguro seguro1 = new Seguro(
                null,
                seguradora,
                veiculo1,
                cliente,
                "123456",
                "ABC123456789",
                50000.00,
                100000.00,
                LocalDate.of(2024, 7, 1),
                LocalDate.of(2025, 6, 30),
                1500.00,
                true,
                true);
        Seguro seguro2 = new Seguro(
                null,
                seguradora,
                veiculo2,
                cliente,
                "654321",
                "DEF987654321",
                40000.00,
                80000.00,
                LocalDate.of(2023, 5, 1),
                LocalDate.of(2024, 4, 30),
                1200.00,
                false,
                false);

        this.seguradoraRepository.save(seguradora);
        this.clienteRepository.save(cliente);
        this.veiculoRepository.save(veiculo1);
        this.veiculoRepository.save(veiculo2);
        this.seguroRepository.save(seguro1);
        this.seguroRepository.save(seguro2);

        List<Seguro> result = this.seguroRepository.findAllByVeiculoId(veiculo1.getId());

        assertThat(result.isEmpty()).isFalse();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(seguro1);
    }

    @Test
    void testFindByCliente() {
        Seguradora seguradora = new Seguradora(
                null,
                "Seguradora Teste",
                "12345678900",
                "segteste@gmail.com",
                "4894700981");
        Cliente cliente1 = new Cliente(
                null,
                "João da Silva",
                "123.456.789-00",
                LocalDate.of(1990, 1, 15),
                "joao.silva@example.com",
                "12345678900",
                "(11) 98765-4321",
                "Solteiro",
                "Masculino",
                "Avenida Brasil",
                "Centro",
                "1000",
                "Apto 101",
                "São Paulo",
                "SP",
                "12345-678");
        Cliente cliente2 = new Cliente(
                null,
                "Maria Souza",
                "987.654.321-00",
                LocalDate.of(1995, 5, 20),
                "maria.souza@example.com",
                "98765432100",
                "(11) 12345-6789",
                "Casada",
                "Feminino",
                "Rua das Flores",
                "Centro",
                "2000",
                "Apto 202",
                "São Paulo",
                "SP",
                "54321-987");
        Veiculo veiculo1 = new Veiculo(
                null,
                "50000",
                "Toyota",
                "Corolla",
                2020,
                "Gasolina",
                "Rua das Flores",
                "Centro",
                "Apt 101",
                123,
                "São Paulo",
                "SP",
                "12345678",
                "ABC1234",
                cliente1);
        Veiculo veiculo2 = new Veiculo(
                null,
                "40000",
                "Honda",
                "Civic",
                2019,
                "Gasolina",
                "Rua dos Carros",
                "Centro",
                "Apt 102",
                456,
                "São Paulo",
                "SP",
                "87654321",
                "DEF5678",
                cliente2);
        Seguro seguro1 = new Seguro(
                null,
                seguradora,
                veiculo1,
                cliente1,
                "123456",
                "ABC123456789",
                50000.00,
                100000.00,
                LocalDate.of(2024, 7, 1),
                LocalDate.of(2025, 6, 30),
                1500.00,
                true,
                true);
        Seguro seguro2 = new Seguro(
                null,
                seguradora,
                veiculo2,
                cliente2,
                "654321",
                "DEF987654321",
                40000.00,
                80000.00,
                LocalDate.of(2023, 5, 1),
                LocalDate.of(2024, 4, 30),
                1200.00,
                false,
                false);

        this.seguradoraRepository.save(seguradora);
        this.clienteRepository.save(cliente1);
        this.clienteRepository.save(cliente2);
        this.veiculoRepository.save(veiculo1);
        this.veiculoRepository.save(veiculo2);
        this.seguroRepository.save(seguro1);
        this.seguroRepository.save(seguro2);

        List<Seguro> result = this.seguroRepository.findByCliente(cliente1);

        assertThat(result.isEmpty()).isFalse();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(seguro1);
    }

    @Test
    void testFindByCliente_WithNoMatchingSeguros() {
        Cliente cliente = new Cliente(
                null,
                "João da Silva",
                "123.456.789-00",
                LocalDate.of(1990, 1, 15),
                "joao.silva@example.com",
                "12345678900",
                "(11) 98765-4321",
                "Solteiro",
                "Masculino",
                "Avenida Brasil",
                "Centro",
                "1000",
                "Apto 101",
                "São Paulo",
                "SP",
                "12345-678");

        this.clienteRepository.save(cliente);

        List<Seguro> result = this.seguroRepository.findByCliente(cliente);

        assertThat(result.isEmpty()).isTrue();
    }
}
