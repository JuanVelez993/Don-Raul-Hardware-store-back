package com.sofkau.DonRaulHardwarestoreback.mapper;

import com.sofkau.DonRaulHardwarestoreback.collection.Product;
import com.sofkau.DonRaulHardwarestoreback.collection.Provider;
import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Function<Product, ProductDTO> fromProductToProductDTO(){
        return product ->  modelMapper.map(product, ProductDTO.class);
    }
    public Function<ProductDTO,Product> fromDTOtoProduct(){
        return productDto ->  modelMapper.map(productDto, Product.class);
    }

}
