package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.ProviderMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.ProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllProvidersCase {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public GetAllProvidersCase(ProviderRepository providerRepository, ProviderMapper providerMapper) {
        this.providerRepository = providerRepository;
        this.providerMapper = providerMapper;
    }


    public Flux<ProviderDTO> getProvider() {
        return providerRepository.findAll()
                .map(resource->providerMapper.fromProviderToProviderDTO().apply(resource));
    }
}

