package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.dto.ReceiptDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.ReceiptMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.ReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllReceiptsCase {
    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;

    public Flux<ReceiptDTO> getReceipts() {
        return receiptRepository.findAll()
                .map(resource->receiptMapper.fromReceiptToReceiptDTO().apply(resource));
    }
}
