package org.example.transfer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransferDto {
    private long id;
    private long clientId;
    private double amount;

    public static TransferDto fromEntity(Transfer transfer) {
        return TransferDto.builder()
                .id(transfer.getId())
                .clientId(transfer.getSender().getId())
                .amount(transfer.getAmount())
                .build();
    }

    public Transfer toEntity() {
        return Transfer.builder()
                .id(id)
                .amount(amount)
                .build();
    }
}
