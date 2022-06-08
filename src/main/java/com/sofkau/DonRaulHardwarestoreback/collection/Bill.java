package com.sofkau.DonRaulHardwarestoreback.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "bill")
public class Bill {
    @Id
    private String id;
    private LocalDateTime date;
    private String client;
    private String clerk;
    private List<Product> products;
    private Double total;
}
