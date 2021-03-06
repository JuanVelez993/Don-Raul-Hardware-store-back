package com.sofkau.DonRaulHardwarestoreback.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "provider")
public class Provider {
    @Id
    private String id;
    private String name;
    private String identification;
    private String phone;

}
