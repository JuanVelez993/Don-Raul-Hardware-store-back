package com.sofkau.DonRaulHardwarestoreback.mapper;

import com.sofkau.DonRaulHardwarestoreback.collection.Receipt;
import com.sofkau.DonRaulHardwarestoreback.dto.ReceiptDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ReceiptMapper {
    private final ModelMapper modelMapper;

    public ReceiptMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ReceiptDTO fromReceiptToReceiptDTO(Receipt receipt){
        return modelMapper.map(receipt, ReceiptDTO.class);
    }

    public Receipt fromDTOtoReceipt(ReceiptDTO receiptDTO){
        return modelMapper.map(receiptDTO, Receipt.class);
    }
}