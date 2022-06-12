package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.collection.Provider;
import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaveProductCaseTest {
    @MockBean
    SaveProductCase saveProductCase;


    @Test
    void SaveProviderTest() {
        ProviderDTO provider = new ProviderDTO();
        provider.setId("thisissomeone");
        provider.setName("charles");
        provider.setIdentification("1037");
        provider.setPhone("3197297679");

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId("someproduct");
        productDTO.setDescription("Long screws");
        productDTO.setCurrentInventory(300);
        productDTO.setMinInventory(150);
        productDTO.setMaxInventory(450);
        productDTO.setPrice(550.0);
        productDTO.setProvider(provider);


        StepVerifier
                .create(Mono.just(Mockito.when(saveProductCase.apply(productDTO))
                        .thenReturn(Mono.just(productDTO)))).expectNextCount(1).expectComplete().verify();


    }

}