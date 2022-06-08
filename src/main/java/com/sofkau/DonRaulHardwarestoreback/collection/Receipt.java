package com.sofkau.DonRaulHardwarestoreback.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "receipt")
public class Receipt {
    @Id
    private String id;
    private LocalDateTime date;
    private String description;
    private Integer units;
    private String productId;
    private Provider provider;
}
