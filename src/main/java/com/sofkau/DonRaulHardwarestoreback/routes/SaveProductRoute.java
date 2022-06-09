package com.sofkau.DonRaulHardwarestoreback.routes;

import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
import com.sofkau.DonRaulHardwarestoreback.usecase.SaveProductCase;
import com.sofkau.DonRaulHardwarestoreback.usecase.SaveProviderCase;
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
public class SaveProductRoute {

    @Bean
    public RouterFunction<ServerResponse> saveProvider(SaveProductCase saveProductCase){
        Function<ProductDTO, Mono<ServerResponse>> executeSave = productDTO -> saveProductCase.apply(productDTO)
                .flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(result));

        return route(POST("/save/product").and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(ProductDTO.class).flatMap(executeSave));
    }
}
