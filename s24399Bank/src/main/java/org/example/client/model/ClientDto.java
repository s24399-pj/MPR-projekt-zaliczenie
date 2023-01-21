package org.example.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientDto {

    private long id;
    private String firstName;
    private String lastName;
    private long pesel;
    private String email;
    private double moneyAmount;

    public static ClientDto fromEntity(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .pesel(client.getPesel())
                .email(client.getEmail())
                .moneyAmount(client.getMoneyAmount())
                .build();
    }

    public Client toEntity() {
        return Client.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .pesel(pesel)
                .email(email)
                .moneyAmount(moneyAmount)
                .build();
    }

}
