package com.projeto.projetospring.service;

import java.util.ArrayList;
import java.util.List;

import com.projeto.projetospring.models.Cliente;
import com.projeto.projetospring.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
