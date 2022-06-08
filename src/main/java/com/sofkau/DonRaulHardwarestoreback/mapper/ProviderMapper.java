package com.sofkau.DonRaulHardwarestoreback.mapper;

import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.stereotype.Component;


@Component
public class ProviderMapper {
    private final ModelMapper modelMapper;

    public ProviderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProviderDTO fromProviderToProviderDTO(Provider provider){
        return modelMapper.map(provider, ProviderDTO.class);
    }

    public Provider fromDTOtoProvider(ProviderDTO providerDTO){
        return modelMapper.map(providerDTO, Provider.class);
    }
}