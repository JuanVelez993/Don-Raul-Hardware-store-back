package com.sofkau.DonRaulHardwarestoreback.mapper;

import com.sofkau.DonRaulHardwarestoreback.collection.Bill;
import com.sofkau.DonRaulHardwarestoreback.collection.Bill;
import com.sofkau.DonRaulHardwarestoreback.dto.BillDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.BillDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class BillMapper {

    private final ModelMapper modelMapper;

    public BillMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Function<Bill, BillDTO> fromBillToBillDTO(){
        return bill ->  modelMapper.map(bill, BillDTO.class);
    }

    public Function<BillDTO, Bill> fromDTOtoBill(){
        return billDto ->  modelMapper.map(billDto, Bill.class);
    }
}
