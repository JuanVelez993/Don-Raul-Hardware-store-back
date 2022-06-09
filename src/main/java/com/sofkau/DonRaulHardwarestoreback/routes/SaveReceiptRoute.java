package com.sofkau.DonRaulHardwarestoreback.routes;

import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ReceiptDTO;
import com.sofkau.DonRaulHardwarestoreback.usecase.SaveProductCase;
import com.sofkau.DonRaulHardwarestoreback.usecase.SaveReceiptCase;
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
public class SaveReceiptRoute {
    @Bean
    public RouterFunction<ServerResponse> saveReceipt(SaveReceiptCase saveReceiptCase){
        Function<ReceiptDTO, Mono<ServerResponse>> executeSave = receiptDTO -> saveReceiptCase.apply(receiptDTO)
                .flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(result));

        return route(POST("/save/receipt").and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(ReceiptDTO.class).flatMap(executeSave));
    }
}
