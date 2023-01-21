package org.example.client;

import lombok.RequiredArgsConstructor;
import org.example.client.model.Client;
import org.example.client.model.ClientDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto saveClient(@RequestBody ClientDto clientDto) {
        Client client = clientService.save(clientDto.toEntity());
        return ClientDto.fromEntity(client);
    }

    @GetMapping("find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto find(@PathVariable("id") long clientId) {
        return ClientDto.fromEntity(clientService.find(clientId));
    }
}
