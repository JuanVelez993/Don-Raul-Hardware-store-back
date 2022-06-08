package com.sofkau.DonRaulHardwarestoreback.dto;

import com.sofkau.DonRaulHardwarestoreback.collection.Provider;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {
    private String id= UUID.randomUUID().toString().substring(0, 10);

    private String name;

    private Integer currentInventory;

    private Integer minInventory;

    private Integer maxInventory;

    private Double price;

    private Provider provider;
}
