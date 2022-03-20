package com.projeto.projetospring.controller;

import java.util.ArrayList;

import com.projeto.projetospring.models.Cliente;
import com.projeto.projetospring.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<ArrayList<Cliente>> findAll() {
        ArrayList<Cliente> clientes = clienteService.findAll();
        return new ResponseEntity<ArrayList<Cliente>>(clientes, HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<String> incluirCliente (Cliente cliente) {
        clienteService.save(cliente);
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @GetMapping(value="/segunda", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView segunda (@RequestParam(value="valor",
        defaultValue = "world", required = false) String nome, Model model){
            model.addAttribute("name", nome);
            return new ModelAndView("segunda");
    }
}
