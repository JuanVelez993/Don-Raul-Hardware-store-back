package com.sofkau.DonRaulHardwarestoreback.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProviderDTO {
    private String id= UUID.randomUUID().toString().substring(0, 10);
    private String name;
    private String phone;
    private String adress;
}
