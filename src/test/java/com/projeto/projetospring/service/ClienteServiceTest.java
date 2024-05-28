package com.projeto.projetospring.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.projetospring.models.Cliente;
import com.projeto.projetospring.repository.ClienteRepository;

public class ClienteServiceTest {

    // Diz para criar um mock da classe com métodos vazios
    @Mock
    private ClienteRepository clienteRepository;

    @Autowired
    @InjectMocks // Injeta os mocks nessa classe
    private ClienteService clienteService;

    // Executa antes de cada teste unitário
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return all clients successfully")
    void testFindAllCase1() {
        Cliente sender = new Cliente("Primeiro", "00000000001");
        Cliente receiver = new Cliente("Segundo", "00000000002");
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(sender);
        clientes.add(receiver);

        when(clienteService.findAll()).thenReturn(clientes);

        // Act
        List<Cliente> result = clienteService.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Primeiro", result.get(0).getNome());
        assertEquals("Segundo", result.get(1).getNome());
    }
    
    @Test
    void testSave() {

    }

    @Test
    void testDeletar() {

    }
}
