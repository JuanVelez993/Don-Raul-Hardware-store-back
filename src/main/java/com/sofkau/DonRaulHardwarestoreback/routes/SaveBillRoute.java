package com.sofkau.DonRaulHardwarestoreback.routes;

import com.sofkau.DonRaulHardwarestoreback.dto.BillDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import com.sofkau.DonRaulHardwarestoreback.usecase.SaveBillCase;
import com.sofkau.DonRaulHardwarestoreback.usecase.SaveProductCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SaveBillRoute {

    @Bean
    public RouterFunction<ServerResponse> saveBill(SaveBillCase saveBillCase){
        Function<BillDTO, Mono<ServerResponse>> executeSave = billDTO -> saveBillCase.apply(billDTO)
                .flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(result));

        return route(POST("/save/bill").and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(BillDTO.class).flatMap(executeSave));
    }
}
