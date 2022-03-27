package com.projeto.projetospring.service;

import java.util.ArrayList;

import com.projeto.projetospring.models.Cliente;
import com.projeto.projetospring.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<Cliente> findAll() {
        ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
        listaRetorno = (ArrayList<Cliente>)clienteRepository.findAll();
        return listaRetorno;
    }

    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
