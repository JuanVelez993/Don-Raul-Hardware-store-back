package com.sofkau.DonRaulHardwarestoreback.mapper;

import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import org.modelmapper.ModelMapper;
import com.sofkau.DonRaulHardwarestoreback.collection.Provider;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class ProviderMapper {
    private final ModelMapper modelMapper;

    public ProviderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Function<Provider, ProviderDTO> fromProviderToProviderDTO(){
        return provider ->  modelMapper.map(provider, ProviderDTO.class);
    }

    public Function<ProviderDTO,Provider > fromDTOtoProvider(){
        return providerDTO ->  modelMapper.map(providerDTO,Provider.class);
    }
}