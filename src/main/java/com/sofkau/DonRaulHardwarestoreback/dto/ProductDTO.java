package com.sofkau.DonRaulHardwarestoreback.dto;

import com.sofkau.DonRaulHardwarestoreback.collection.Provider;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {
    private String id;

    private String description;

    private Integer currentInventory;

    private Integer minInventory;

    private Integer maxInventory;

    private Double price;

    private ProviderDTO provider;
}
