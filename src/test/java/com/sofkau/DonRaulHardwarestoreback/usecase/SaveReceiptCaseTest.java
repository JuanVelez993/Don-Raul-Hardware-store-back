package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.collection.Provider;
import com.sofkau.DonRaulHardwarestoreback.collection.Receipt;
import com.sofkau.DonRaulHardwarestoreback.dto.ReceiptDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaveReceiptCaseTest {
    @MockBean
    SaveReceiptCase saveReceiptCase;

    @Test
    void saveReceiptTest() {
        Provider provider = new Provider();
        provider.setId("testme");
        provider.setName("juan");
        provider.setIdentification("1037");
        provider.setPhone("3197297679");

        ReceiptDTO receipt = new ReceiptDTO();
        receipt.setId("onereceiptID");
        receipt.setDate("23/04/2022");
        receipt.setDescription("hammer");
        receipt.setUnits(55);
        receipt.setProductId("aaaaa");
        receipt.setProvider(provider);



        StepVerifier
                .create(Mono.just(Mockito.when(saveReceiptCase.apply(receipt))
                        .thenReturn(Mono.just(receipt)))).expectNextCount(1).expectComplete().verify();


    }

}