package com.sofkau.DonRaulHardwarestoreback.usecase;


import com.sofkau.DonRaulHardwarestoreback.dto.BillDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.BillMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllBillsCase {
    private final BillRepository billRepository;
    private final BillMapper billMapper;

    public Flux<BillDTO> getBills() {
        return billRepository.findAll()
                .map(resource->billMapper.fromBillToBillDTO().apply(resource));
    }
}
