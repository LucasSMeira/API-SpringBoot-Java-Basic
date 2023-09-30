package com.br.api.service;

import com.br.api.model.Endereco; // Corrigido o import
import com.br.api.repository.EnderecoRepository;
import com.br.api.service.EnderecoService; // Corrigido o impor

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> obterEndereco(Integer id) {
        return enderecoRepository.findById(id);
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco atualizarEndereco(Integer id, Endereco enderecoAtualizado) {
        if (enderecoRepository.existsById(id)) {
            enderecoAtualizado.setId(id);
            return enderecoRepository.save(enderecoAtualizado);
        }
        return null;
    }

    public void deletarEndereco(Integer id) {
        enderecoRepository.deleteById(id);
    }
}
