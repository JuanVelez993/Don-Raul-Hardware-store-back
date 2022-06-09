package com.sofkau.DonRaulHardwarestoreback.usecase.interfaces;

import com.sofkau.DonRaulHardwarestoreback.dto.ReceiptDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveReceipt {
    Mono<ReceiptDTO> apply (ReceiptDTO providerDto);
}
