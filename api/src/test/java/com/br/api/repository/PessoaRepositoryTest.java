package com.br.api.repository;

import com.br.api.model.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void testSavePessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste Nome");
        Pessoa savedPessoa = pessoaRepository.save(pessoa);

        assertThat(savedPessoa).isNotNull();
        assertThat(savedPessoa.getId()).isNotNull();
    }

    @Test
    public void testFindById() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste Nome");
        Pessoa savedPessoa = pessoaRepository.save(pessoa);

        Optional<Pessoa> foundPessoa = pessoaRepository.findById(savedPessoa.getId());
        assertThat(foundPessoa).isPresent();
        assertThat(foundPessoa.get().getNome()).isEqualTo("Teste Nome");
    }
}
