package com.br.api.controller;


import com.br.api.model.Endereco; // Corrigido o import
import com.br.api.service.EnderecoService; // Corrigido o import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
public class EnderecoController {

    @Autowired 
    private EnderecoService enderecoService;


    @PostMapping
    public Endereco criarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.criarEndereco(endereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> obterEndereco(@PathVariable Integer id) {
        return enderecoService.obterEndereco(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Endereco> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Integer id, @RequestBody Endereco enderecoAtualizado) {
        Endereco endereco = enderecoService.atualizarEndereco(id, enderecoAtualizado);
        if (endereco != null) {
            return ResponseEntity.ok(endereco);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Integer id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
