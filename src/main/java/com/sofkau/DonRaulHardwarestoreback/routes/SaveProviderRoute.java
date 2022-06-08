package com.sofkau.DonRaulHardwarestoreback.routes;

import com.sofkau.DonRaulHardwarestoreback.dto.ProviderDTO;
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
public class SaveProviderRoute {
    @Bean
    public RouterFunction<ServerResponse> saveProvider(SaveProviderCase saveProviderCase){
        Function<ProviderDTO, Mono<ServerResponse>> executeSave = spellDTO -> saveProviderCase.apply(spellDTO)
                .flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(result));

        return route(POST("/save/provider").and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(ProviderDTO.class).flatMap(executeSave));
    }
}
