package com.sofkau.DonRaulHardwarestoreback.usecase.interfaces;

import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveProvider {
    Mono<ProviderDTO> apply (ProviderDTO providerDto);
}
