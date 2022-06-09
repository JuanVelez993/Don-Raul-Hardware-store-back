package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.ProductMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.ProductRepository;
import com.sofkau.DonRaulHardwarestoreback.usecase.interfaces.UpdateProduct;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class UpdateProductCase implements UpdateProduct {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public UpdateProductCase(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Mono<ProductDTO> apply(ProductDTO productDTO) {
        Objects.requireNonNull(productDTO.getId());
        return productRepository.save(productMapper.fromDTOtoProduct().apply(productDTO))
                .map(product-> productMapper.fromProductToProductDTO().apply(product));
    }
}
