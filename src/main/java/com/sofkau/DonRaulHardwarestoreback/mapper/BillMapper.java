package com.sofkau.DonRaulHardwarestoreback.mapper;

import com.sofkau.DonRaulHardwarestoreback.collection.Bill;
import com.sofkau.DonRaulHardwarestoreback.dto.BillDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class BillMapper {

    private final ModelMapper modelMapper;

    public BillMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public BillDTO fromBillToBillDTO(Bill bill){
        return modelMapper.map(bill, BillDTO.class);
    }

    public Bill fromDTOtoBill(BillDTO billDTO){
        return modelMapper.map(billDTO, Bill.class);
    }
}
