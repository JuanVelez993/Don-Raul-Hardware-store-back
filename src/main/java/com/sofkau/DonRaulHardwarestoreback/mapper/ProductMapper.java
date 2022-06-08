package com.sofkau.DonRaulHardwarestoreback.mapper;

import com.sofkau.DonRaulHardwarestoreback.collection.Product;
import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDTO fromProductToProductDTO(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product fromDTOtoProduct(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }
}
