package com.sofkau.DonRaulHardwarestoreback.routes;

import com.sofkau.DonRaulHardwarestoreback.usecase.DeleteProductCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteProductRoute {
    @Bean
    public RouterFunction<ServerResponse> deleteProduct(DeleteProductCase deleteProductCase) {

        return route(
                DELETE("/delete/product/{id}"),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(deleteProductCase.apply(request.pathVariable("id")), Void.class)));
    }
}
