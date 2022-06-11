package com.sofkau.DonRaulHardwarestoreback.usecase;

import com.sofkau.DonRaulHardwarestoreback.dto.BillDTO;
import com.sofkau.DonRaulHardwarestoreback.mapper.BillMapper;
import com.sofkau.DonRaulHardwarestoreback.repository.BillRepository;
import com.sofkau.DonRaulHardwarestoreback.usecase.interfaces.SaveBill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SaveBillCase implements SaveBill {
    private final BillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public Mono<BillDTO> apply(BillDTO billDTO) {
        return billRepository.save(billMapper.fromDTOtoBill().apply(billDTO)).map(product -> billMapper.fromBillToBillDTO().apply(product));
    }
}
