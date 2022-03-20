package com.projeto.projetospring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="cliente")
@Setter
@Getter
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private Character sexo;

    @Column
    private String telefone;

    public Cliente () {

    }

    public Cliente (String nome) {
        this.nome = nome;
    }

    public Cliente (String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente (String nome, String cpf, Character sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public Cliente (String nome, String cpf, Character sexo, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.telefone = telefone;
    }
}
