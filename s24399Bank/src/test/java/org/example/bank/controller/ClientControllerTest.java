package org.example.bank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.client.ClientRepository;
import org.example.client.model.Client;
import org.example.client.model.ClientDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldFindAllClients() throws Exception {
        ClientDto clientDto1 = ClientDto.builder()
                .id(1)
                .firstName("Satoshi")
                .lastName("Nakamoto")
                .email("twinturbov8@combustion.engine")
                .moneyAmount(1000)
                .pesel(2231202931l)
                .build();

        ClientDto clientDto2 = ClientDto.builder()
                .id(2)
                .firstName("Andrew")
                .lastName("Nakamoto")
                .email("example@email.com")
                .moneyAmount(102200)
                .pesel(22319212931l)
                .build();

        when(clientRepository.findAll()).thenReturn((Arrays.asList(clientDto1.toEntity(),clientDto2.toEntity())));
        when(clientRepository.save(any())).thenReturn(clientDto1.toEntity()).thenReturn((clientDto2.toEntity()));

        mockMvc.perform(post("/api/v1/clients")
                .with(SecurityMockMvcRequestPostProcessors.user("admin").password("admin"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clientDto1)))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/api/v1/clients")
                        .with(SecurityMockMvcRequestPostProcessors.user("admin").password("admin"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientDto2)))
                .andExpect(status().isCreated());


    }
}
