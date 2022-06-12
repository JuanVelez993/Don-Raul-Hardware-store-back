package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.collection.Provider;
import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.ProviderMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.ProviderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllProvidersTest {
    private GetAllProvidersCase getAllProvidersCase;

    @Autowired
    private ProviderMapper providerMapper;

    @Mock
    ProviderRepository providerRepository;

    @BeforeEach
    void setUp() {
        getAllProvidersCase = new GetAllProvidersCase(providerRepository, providerMapper);
    }

    @Test
    void GetAllProvidersTest() {
        Provider provider1 = new Provider();
        Provider provider2 = new Provider();
        provider1.setId("firstprovider");
        provider2.setId("secondprovider");
        provider1.setName("elliot");
        provider2.setName("mike");
        provider1.setIdentification("1234");
        provider2.setIdentification("5678");
        provider1.setPhone("741852");
        provider2.setPhone("396852");

        Mockito.when(providerRepository.findAll()).thenReturn(Flux.just(provider1, provider2));
        Flux<ProviderDTO> providerDTOFlux = getAllProvidersCase.getProvider();

        StepVerifier.create(providerDTOFlux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(providerRepository).findAll();

    }

}