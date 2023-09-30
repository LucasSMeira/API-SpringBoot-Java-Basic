package com.br.api.repository;

import com.br.api.model.Endereco;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class EnderecoRepositoryTest {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Test
    public void testSaveEndereco() {
        Endereco endereco = new Endereco("Rua A", "12345", "100", "Cidade X");
        Endereco savedEndereco = enderecoRepository.save(endereco);

        assertThat(savedEndereco).isNotNull();
        assertThat(savedEndereco.getId()).isNotNull();
    }

    @Test
    public void testFindById() {
        Endereco endereco = new Endereco("Rua A", "12345", "100", "Cidade X");
        Endereco savedEndereco = enderecoRepository.save(endereco);

        Optional<Endereco> foundEndereco = enderecoRepository.findById(savedEndereco.getId());
        assertThat(foundEndereco).isPresent();
        assertThat(foundEndereco.get().getLogradouro()).isEqualTo("Rua A");
    }
}
