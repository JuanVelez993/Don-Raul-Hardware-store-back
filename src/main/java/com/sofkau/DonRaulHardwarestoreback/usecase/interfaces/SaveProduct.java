package com.sofkau.DonRaulHardwarestoreback.usecase.interfaces;

import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveProduct {
    Mono<ProductDTO> apply (ProductDTO productDTO);
}
