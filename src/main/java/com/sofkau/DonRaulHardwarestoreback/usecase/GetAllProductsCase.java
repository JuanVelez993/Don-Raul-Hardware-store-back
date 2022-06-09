package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.ProductMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllProductsCase {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public GetAllProductsCase(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Flux<ProductDTO> getProducts() {
        return productRepository.findAll()
                .map(resource->productMapper.fromProductToProductDTO().apply(resource));
    }
}
