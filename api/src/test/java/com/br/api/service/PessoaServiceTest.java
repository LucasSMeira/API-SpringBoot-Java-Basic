package com.br.api.service;

import com.br.api.model.Pessoa;
import com.br.api.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarPessoa() {
        Pessoa pessoa = new Pessoa();
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa resultado = pessoaService.criarPessoa(pessoa);

        assertEquals(pessoa, resultado);
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    public void testObterPessoa() {
        Pessoa pessoa = new Pessoa();
        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));

        Optional<Pessoa> resultado = pessoaService.obterPessoa(1L);

        assertTrue(resultado.isPresent());
        assertEquals(pessoa, resultado.get());
    }
}
