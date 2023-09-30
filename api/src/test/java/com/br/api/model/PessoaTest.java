package com.br.api.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

    private Pessoa pessoa;
    private Endereco endereco;

    @BeforeEach
    public void setUp() {
        endereco = new Endereco("Rua A", "12345", "100", "Cidade X");
        pessoa = new Pessoa();
        pessoa.setNome("Nome Teste");
        pessoa.setDataNascimento(new Date());
        pessoa.setEnderecos(Arrays.asList(endereco));
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("Nome Teste", pessoa.getNome());
        assertEquals(Arrays.asList(endereco), pessoa.getEnderecos());

        pessoa.setNome("Outro Nome");
        pessoa.setEnderecos(null);

        assertEquals("Outro Nome", pessoa.getNome());
        assertEquals(null, pessoa.getEnderecos());
    }
}
