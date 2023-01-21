package org.example.transfer;

import lombok.RequiredArgsConstructor;
import org.example.transfer.model.Transfer;
import org.example.transfer.model.TransferDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rentals")
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransferDto> getTransfers() {
        return transferService.findAll()
                .stream()
                .map(TransferDto::fromEntity)
                .toList();
    }

    @PostMapping(value = "deposit/")
    @ResponseStatus(HttpStatus.CREATED)
    public TransferDto depositMoney(@RequestBody TransferDto transferDto) {
        long senderId = transferDto.getClientId();
        Transfer transfer = transferService.depositMoney(transferDto.toEntity(), senderId);
        return TransferDto.fromEntity(transfer);
    }

    @PostMapping(value = "transfer/")
    @ResponseStatus(HttpStatus.CREATED)
    public TransferDto transferMoney(@RequestBody TransferDto transferDto) {
        long senderId = transferDto.getClientId();
        Transfer transfer = transferService.transferMoney(transferDto.toEntity(), senderId);
        return TransferDto.fromEntity(transfer);
    }

}
