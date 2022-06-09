package com.sofkau.DonRaulHardwarestoreback.mapper;

import com.sofkau.DonRaulHardwarestoreback.collection.Receipt;
import com.sofkau.DonRaulHardwarestoreback.collection.Receipt;
import com.sofkau.DonRaulHardwarestoreback.collection.Receipt;
import com.sofkau.DonRaulHardwarestoreback.dto.ReceiptDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ReceiptDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ReceiptDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class ReceiptMapper {
    private final ModelMapper modelMapper;

    public ReceiptMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public Function<Receipt, ReceiptDTO> fromReceiptToReceiptDTO(){
        return receipt ->  modelMapper.map(receipt, ReceiptDTO.class);
    }

    public Function<ReceiptDTO, Receipt> fromDTOtoReceipt(){
        return receiptDto ->  modelMapper.map(receiptDto, Receipt.class);
    }
}