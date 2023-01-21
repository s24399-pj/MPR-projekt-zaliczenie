package org.example.transfer;

import lombok.RequiredArgsConstructor;
import org.example.client.ClientService;
import org.example.client.model.Client;
import org.example.transfer.model.Transfer;
import org.example.transfer.model.TransferType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferService {
    private final TransferRepository transferRepository;
    private final ClientService clientService;

    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    public Transfer transferMoney(Transfer transfer, long clientId) {
        Client client = clientService.find(clientId);
        double moneyAmount = transfer.getAmount();
        client.setMoneyAmount(client.getMoneyAmount() - moneyAmount);
        transfer.setSender(client);
        transfer.setTransferType(TransferType.ACCEPTED);
        return transferRepository.save(transfer);
    }

    public Transfer depositMoney(Transfer transfer, long clientId){
        Client client = clientService.find(clientId);
        double moneyAmount = transfer.getAmount();
        client.setMoneyAmount(client.getMoneyAmount() + moneyAmount);
        transfer.setSender(client);
        transfer.setTransferType(TransferType.ACCEPTED);
        return transferRepository.save(transfer);
    }
}
