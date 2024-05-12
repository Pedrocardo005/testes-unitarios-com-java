package com.projeto.projetospring.repository;

import com.projeto.projetospring.models.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    Optional<Cliente> findClienteByNome(String nome);
}
