package com.sofkau.DonRaulHardwarestoreback.routes;

import com.sofkau.DonRaulHardwarestoreback.dto.ProductDTO;
import com.sofkau.DonRaulHardwarestoreback.usecase.UpdateProductCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateProductRoute {
    @Bean
    public RouterFunction<ServerResponse> updateProduct(UpdateProductCase updateProductCase){
        Function<ProductDTO, Mono<ServerResponse>> executor =
                productDTO -> updateProductCase.apply(productDTO)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(PUT("/update/product")
                .and(accept(MediaType.APPLICATION_JSON)), request -> request
                .bodyToMono(ProductDTO.class)
                .flatMap(executor));
    }
}
