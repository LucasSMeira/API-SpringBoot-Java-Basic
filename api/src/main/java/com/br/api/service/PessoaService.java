package com.br.api.service;

import com.br.api.model.Pessoa;
import com.br.api.service.PessoaService;
import com.br.api.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> obterPessoa(Long id) {
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        if (pessoaRepository.existsById(id)) {
            pessoaAtualizada.setId(id);
            return pessoaRepository.save(pessoaAtualizada);
        }
        return null;
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
