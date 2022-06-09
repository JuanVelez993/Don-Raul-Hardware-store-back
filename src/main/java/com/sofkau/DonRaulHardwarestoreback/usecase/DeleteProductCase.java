package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.mapper.ProductMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.ProductRepository;
import com.sofkau.DonRaulHardwarestoreback.usecase.interfaces.DeleteProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteProductCase implements DeleteProduct {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Mono<Void> apply(String id) {
        return productRepository.deleteById(id);
    }
}
