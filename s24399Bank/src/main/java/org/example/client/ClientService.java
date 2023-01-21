package org.example.client;

import lombok.RequiredArgsConstructor;
import org.example.client.model.Client;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client find(long clientId){
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client with provided id doesnt exist !"));
    }
}
