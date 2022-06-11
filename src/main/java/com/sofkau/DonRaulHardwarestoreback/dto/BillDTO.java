package com.sofkau.DonRaulHardwarestoreback.dto;

import com.sofkau.DonRaulHardwarestoreback.collection.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class BillDTO {
    private String id;
    private String date;
    private String client;
    private String clerk;
    private List<ProductDTO> products;
    private Double total;
}
