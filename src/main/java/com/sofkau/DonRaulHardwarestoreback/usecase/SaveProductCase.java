package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.ProductMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.ProductRepository;
import com.sofkau.DonRaulHardwarestoreback.usecase.interfaces.SaveProduct;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SaveProductCase implements SaveProduct {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public SaveProductCase(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public Mono<ProductDTO> apply(ProductDTO productDTO) {
        return productRepository.save(productMapper.fromDTOtoProduct().apply(productDTO)).map(product -> productMapper.fromProductToProductDTO().apply(product));
    }
}
