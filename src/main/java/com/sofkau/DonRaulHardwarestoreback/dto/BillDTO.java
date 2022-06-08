package com.sofkau.DonRaulHardwarestoreback.dto;

import com.sofkau.DonRaulHardwarestoreback.collection.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class BillDTO {
    private String id= UUID.randomUUID().toString().substring(0, 10);;
    private LocalDateTime date;
    private String client;
    private String clerk;
    private List<Product> products;
    private Double total;
}
