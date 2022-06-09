package com.sofkau.DonRaulHardwarestoreback.routes;

import com.sofkau.DonRaulHardwarestoreback.dto.ReceiptDTO;
import com.sofkau.DonRaulHardwarestoreback.usecase.GetAllReceiptsCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllReceiptsRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllReceiptsRouter(GetAllReceiptsCase getAllReceiptsCase){
        return route(GET("/all/receipts"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllReceiptsCase.getReceipts(), ReceiptDTO.class)));
    }
}
