package com.sofkau.DonRaulHardwarestoreback.usecase.interfaces;


import com.sofkau.DonRaulHardwarestoreback.dto.BillDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveBill {
    Mono<BillDTO> apply (BillDTO billDTO);
}
