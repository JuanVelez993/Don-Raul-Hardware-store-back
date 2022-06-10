package com.sofkau.DonRaulHardwarestoreback.collection;

import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "product")
public class Product {
    @Id
    private String id;

    private String description;

    private Integer currentInventory;

    private Integer minInventory;

    private Integer maxInventory;

    private Double price;

    private ProviderDTO provider;


}
