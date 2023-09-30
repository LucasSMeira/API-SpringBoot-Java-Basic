package com.br.api.service;

import com.br.api.model.Endereco;
import com.br.api.repository.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EnderecoServiceTest {

    @InjectMocks
    private EnderecoService enderecoService;

    @Mock
    private EnderecoRepository enderecoRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarEndereco() {
        Endereco endereco = new Endereco();
        when(enderecoRepository.save(any(Endereco.class))).thenReturn(endereco);

        Endereco resultado = enderecoService.criarEndereco(endereco);

        assertEquals(endereco, resultado);
        verify(enderecoRepository, times(1)).save(endereco);
    }

    @Test
    public void testObterEndereco() {
        Endereco endereco = new Endereco();
        when(enderecoRepository.findById(1)).thenReturn(Optional.of(endereco));

        Optional<Endereco> resultado = enderecoService.obterEndereco(1);

        assertTrue(resultado.isPresent());
        assertEquals(endereco, resultado.get());
    }
}
