package com.br.api.controller;

import com.br.api.model.Pessoa;
import com.br.api.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PessoaControllerTest {

    @InjectMocks
    private PessoaController pessoaController;

    @Mock
    private PessoaService pessoaService;

    private Pessoa pessoa = new Pessoa();

    @Test
    public void testCriarPessoa() {
        Pessoa pessoa = new Pessoa();
        when(pessoaService.criarPessoa(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa resultado = pessoaController.criarPessoa(pessoa);

        assertEquals(pessoa, resultado);
        verify(pessoaService, times(1)).criarPessoa(pessoa);
    }

    @Test
    public void testObterPessoa() {
        when(pessoaService.obterPessoa(1L)).thenReturn(Optional.of(pessoa));
    
        ResponseEntity<Pessoa> response = pessoaController.obterPessoa(1L);
    
        assertEquals(200, response.getStatusCode().value()); // Modificado aqui
        assertEquals(pessoa, response.getBody());
    }
    
    @Test
    public void testObterPessoaNotFound() {
        when(pessoaService.obterPessoa(1L)).thenReturn(Optional.empty());
    
        ResponseEntity<Pessoa> response = pessoaController.obterPessoa(1L);
    
        assertEquals(404, response.getStatusCode().value()); // Modificado aqui
    }
    


}
