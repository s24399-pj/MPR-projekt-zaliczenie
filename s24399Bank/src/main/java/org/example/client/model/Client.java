package org.example.client.model;

import lombok.*;
import org.example.transfer.model.Transfer;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private long pesel;

    @Column(unique = true)
    private String email;

    private double moneyAmount;

    @OneToMany(mappedBy = "client")
    private Set<Transfer> transfers;
}
