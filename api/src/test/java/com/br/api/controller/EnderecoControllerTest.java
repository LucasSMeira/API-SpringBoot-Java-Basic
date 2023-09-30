package com.br.api.controller;

import com.br.api.model.Endereco;
import com.br.api.service.EnderecoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EnderecoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EnderecoService enderecoService;

    @InjectMocks
    private EnderecoController enderecoController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(enderecoController)
                .build();
    }

    @Test
    public void testCriarEndereco() throws Exception {
        Endereco endereco = new Endereco();
        endereco.setId(1);
        endereco.setLogradouro("Rua Exemplo");

        when(enderecoService.criarEndereco(endereco)).thenReturn(endereco);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(endereco);

        mockMvc.perform(post("/endereco")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testObterEndereco() throws Exception {
        Endereco endereco = new Endereco();
        endereco.setId(1);

        when(enderecoService.obterEndereco(1)).thenReturn(Optional.of(endereco));

        mockMvc.perform(get("/endereco/1"))
                .andExpect(status().isOk());
    }

    // Adicione testes semelhantes para outros métodos do controlador
}
