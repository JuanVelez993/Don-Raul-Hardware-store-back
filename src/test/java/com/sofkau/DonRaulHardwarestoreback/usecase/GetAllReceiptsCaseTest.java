package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.collection.Provider;
import com.sofkau.DonRaulHardwarestoreback.collection.Receipt;
import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ReceiptDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.ReceiptMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.ReceiptRepository;
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
class GetAllReceiptsCaseTest {

    private GetAllReceiptsCase getReceiptUseCase;

    @Autowired
    private ReceiptMapper receiptMapper;

    @Mock
    ReceiptRepository receiptRepository;

    @BeforeEach
    void setUp(){
        getReceiptUseCase = new GetAllReceiptsCase(receiptRepository, receiptMapper);
    }

    @Test
    void getReceiptTest(){
        Provider provider = new Provider();
        provider.setId("testme");
        provider.setName("juan");
        provider.setIdentification("1037");
        provider.setPhone("3197297679");

        Receipt receipt = new Receipt();
        receipt.setId("onereceiptID");
        receipt.setDate("23/04/2022");
        receipt.setDescription("hammer");
        receipt.setUnits(55);
        receipt.setProductId("aaaaa");
        receipt.setProvider(provider);

        Receipt receipt2 = new Receipt();
        receipt2.setId("tworeceiptID");
        receipt2.setDate("23/04/2022");
        receipt2.setDescription("screws");
        receipt2.setUnits(34);
        receipt2.setProductId("bbbbb");
        receipt2.setProvider(provider);

        Mockito.when(receiptRepository.findAll()).thenReturn(Flux.just(receipt,receipt2));
        Flux<ReceiptDTO> flux = getReceiptUseCase.getReceipts();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(receiptRepository).findAll();
    }

}