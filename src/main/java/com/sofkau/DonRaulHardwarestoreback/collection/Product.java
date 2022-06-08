package com.sofkau.DonRaulHardwarestoreback.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "product")
public class Product {
    @Id
    private String id;

    private String name;

    private Integer currentInventory;

    private Integer minInventory;

    private Integer maxInventory;

    private Double price;

    private Provider provider;


}
