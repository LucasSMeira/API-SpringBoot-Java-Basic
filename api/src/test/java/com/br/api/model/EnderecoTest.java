package com.br.api.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnderecoTest {

    private Endereco endereco;

    @BeforeEach
    public void setUp() {
        endereco = new Endereco("Rua A", "12345", "100", "Cidade X");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("Rua A", endereco.getLogradouro());
        assertEquals("12345", endereco.getCep());
        assertEquals("100", endereco.getNumero());
        assertEquals("Cidade X", endereco.getCidade());

        endereco.setLogradouro("Rua B");
        endereco.setCep("67890");
        endereco.setNumero("200");
        endereco.setCidade("Cidade Y");

        assertEquals("Rua B", endereco.getLogradouro());
        assertEquals("67890", endereco.getCep());
        assertEquals("200", endereco.getNumero());
        assertEquals("Cidade Y", endereco.getCidade());
    }
}
