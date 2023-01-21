package org.example.bank.service;

import org.example.client.model.Client;
import org.example.transfer.TransferRepository;
import org.example.transfer.TransferService;
import org.example.transfer.model.Transfer;
import org.example.transfer.model.TransferType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransferServiceTest {

    @Mock
    private TransferRepository transferRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    void shouldFindAllTransfers(){
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

        Transfer transfer1 = Transfer.builder()
                .id(1)
                .sender(client1)
                .amount(100)
                .transferType(TransferType.ACCEPTED)
                .build();

        Transfer transfer2 = Transfer.builder()
                .id(2)
                .sender(client2)
                .amount(200)
                .transferType(TransferType.ACCEPTED)
                .build();

        List<Transfer> transfers = new ArrayList<>(Arrays.asList(transfer1,transfer2));
        when(transferRepository.findAll()).thenReturn(transfers);
        List<Transfer> transfersFound = transferService.findAll();
        assertEquals(transfers,transfersFound);
    }

}
