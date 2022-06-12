package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.collection.Product;
import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.ProductMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.ProductRepository;
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
class GetAllProductsCaseTest {

    private GetAllProductsCase getAllProductsCase;

    @Autowired
    private ProductMapper productMapper;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        getAllProductsCase = new GetAllProductsCase(productRepository, productMapper);
    }

    @Test
    void GetAllProductsTest() {
        ProviderDTO provider = new ProviderDTO();
        provider.setId("thisissomeone");
        provider.setName("charles");
        provider.setIdentification("1037");
        provider.setPhone("3197297679");

        Product product = new Product();
        product.setId("someproduct");
        product.setDescription("Long screws");
        product.setCurrentInventory(300);
        product.setMinInventory(150);
        product.setMaxInventory(450);
        product.setPrice(550.0);
        product.setProvider(provider);

        ProviderDTO provider1 = new ProviderDTO();
        provider.setId("thisissomeone1");
        provider.setName("charles1");
        provider.setIdentification("10371");
        provider.setPhone("31972976791");

        Product product1 = new Product();
        product.setId("someproduct1");
        product.setDescription("short screws");
        product.setCurrentInventory(350);
        product.setMinInventory(158);
        product.setMaxInventory(458);
        product.setPrice(550.0);
        product.setProvider(provider1);

        Mockito.when(productRepository.findAll()).thenReturn(Flux.just(product,product1));
        Flux<ProductDTO> productDTOFlux = getAllProductsCase.getProducts();

        StepVerifier.create(productDTOFlux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(productRepository).findAll();

    }

}