package org.example.transfer.model;

import lombok.*;
import org.example.client.model.Client;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Client sender;
    private double amount;

    @Enumerated(EnumType.STRING)
    private TransferType transferType;
}
