package com.sofkau.DonRaulHardwarestoreback.dto;

import com.sofkau.DonRaulHardwarestoreback.collection.Product;
import com.sofkau.DonRaulHardwarestoreback.collection.Provider;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class ReceiptDTO {
    private String id;
    private LocalDateTime date;
    private String description;
    private Integer units;
    private String productId;
    private Provider provider;
}
