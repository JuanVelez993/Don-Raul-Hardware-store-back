package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.collection.Bill;
import com.sofkau.DonRaulHardwarestoreback.dto.BillDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.BillMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.BillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaveBillCaseTest {

    @MockBean
    SaveBillCase saveBillCase;


    @Test
    void SaveBillTest() {
        ProviderDTO provider = new ProviderDTO();
        provider.setId("thisissomeone");
        provider.setName("charles");
        provider.setIdentification("1037");
        provider.setPhone("3197297679");

        ProductDTO productInbill= new ProductDTO();
        productInbill.setId("someproduct");
        productInbill.setDescription("Long screws");
        productInbill.setCurrentInventory(300);
        productInbill.setMinInventory(150);
        productInbill.setMaxInventory(450);
        productInbill.setPrice(550.0);
        productInbill.setProvider(provider);

        BillDTO bill = new BillDTO();
        bill.setId("somebill");
        bill.setDate("22/07/2021");
        bill.setClient("Peter");
        bill.setClerk("Raul");
        bill.setProducts(List.of(productInbill));
        bill.setTotal(1000.0);



        StepVerifier
                .create(Mono.just(Mockito.when(saveBillCase.apply(bill))
                        .thenReturn(Mono.just(bill)))).expectNextCount(1).expectComplete().verify();


    }



}