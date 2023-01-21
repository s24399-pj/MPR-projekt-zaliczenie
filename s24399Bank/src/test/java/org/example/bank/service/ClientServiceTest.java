package org.example.bank.service;

import org.example.client.ClientRepository;
import org.example.client.ClientService;
import org.example.client.model.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    void shouldFindAllClients() {
        Client client1 = Client.builder()
                .id(1)
                .firstName("Satoshi")
                .lastName("Nakamoto")
                .email("twinturbov8@combustion.engine")
                .moneyAmount(1000)
                .pesel(2231202931l)
                .build();

        Client client2 = Client.builder()
                .id(2)
                .firstName("Andrew")
                .lastName("Nakamoto")
                .email("example@email.com")
                .moneyAmount(102200)
                .pesel(22319212931l)
                .build();

        List<Client> clients = new ArrayList<>(Arrays.asList(client1, client2));
        when(clientRepository.findAll()).thenReturn(clients);
        List<Client> clientsFound = clientService.findAll();
        assertEquals(clients, clientsFound);
    }
}
