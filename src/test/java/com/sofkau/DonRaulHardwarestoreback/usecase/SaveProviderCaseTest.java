package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SaveProviderCaseTest {

    @MockBean
    SaveProviderCase saveProviderCase;

    @Test
    void SaveProviderTest() {
    ProviderDTO providerDTO = new ProviderDTO();
        providerDTO.setId("testme");
        providerDTO.setName("juan");
        providerDTO.setIdentification("1037");
        providerDTO.setPhone("3197297679");



        StepVerifier
                .create(Mono.just(Mockito.when(saveProviderCase.apply(providerDTO))
            .thenReturn(Mono.just(providerDTO)))).expectNextCount(1).expectComplete().verify();


}

}