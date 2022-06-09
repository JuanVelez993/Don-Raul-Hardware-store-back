package com.sofkau.DonRaulHardwarestoreback.usecase;


import com.sofkau.DonRaulHardwarestoreback.dto.ReceiptDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.ReceiptMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.ReceiptRepository;
import com.sofkau.DonRaulHardwarestoreback.usecase.interfaces.SaveReceipt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SaveReceiptCase implements SaveReceipt {
    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;

    @Override
    public Mono<ReceiptDTO> apply(ReceiptDTO receiptDTO) {
        return receiptRepository.save(receiptMapper.fromDTOtoReceipt().apply(receiptDTO)).map(receipt->receiptMapper.fromReceiptToReceiptDTO().apply(receipt));
    }
}
