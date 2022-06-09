package com.sofkau.DonRaulHardwarestoreback.usecase.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteProduct {
    Mono<Void> apply(String id);
}
