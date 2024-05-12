package com.projeto.projetospring.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import com.projeto.projetospring.models.Cliente;

@DataJpaTest
@ActiveProfiles("test") // indica que deve usar o application-test.properties
public class ClienteRepositoryTest {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EntityManager entityManager;

    // Os métodos padrões não precisam ser testados porque o spring já testa eles
    @Test
    @DisplayName("Should get Cliente sucessfully from DB")
    void findClienteByNomeCase1() {
        Cliente cliente = new Cliente("Pedro", "00000000001", 'M', "71999999999");
        this.createCliente(cliente);
        //this.clienteRepository.save(cliente); Parece que tanto faz esse ou o de cima

        Optional<Cliente> result = this.clienteRepository.findClienteByNome("Pedro");

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get Cliente from DB when cliente not exists")
    void findClienteByNomeCase2() {

        Optional<Cliente> result = this.clienteRepository.findClienteByNome("Pedro");

        assertThat(result.isEmpty()).isTrue();
    }

    private Cliente createCliente(Cliente cliente) {
        this.entityManager.persist(cliente);
        return cliente;
    }
}
