package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import com.sofkau.DonRaulHardwarestoreback.collection.Provider;
import com.sofkau.DonRaulHardwarestoreback.mapper.ProviderMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.ProviderRepository;
import com.sofkau.DonRaulHardwarestoreback.usecase.interfaces.SaveProvider;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SaveProviderCase implements SaveProvider {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public SaveProviderCase(ProviderRepository providerRepository, ProviderMapper providerMapper) {
        this.providerRepository = providerRepository;
        this.providerMapper = providerMapper;
    }


    @Override
    public Mono<ProviderDTO> apply(ProviderDTO providerDTO) {
        return providerRepository.save(providerMapper.fromDTOtoProvider().apply(providerDTO)).map(provider->providerMapper.fromProviderToProviderDTO().apply(provider));
    }
}
