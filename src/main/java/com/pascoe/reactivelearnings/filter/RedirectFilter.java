package com.pascoe.reactivelearnings.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.client.WebClient.*;

public class RedirectFilter implements GlobalFilter {

    WebClient webClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return null;
    }

    Mono<ResponseSpec> buildExchange(ServerWebExchange exchange) {
        webClient.get()

    }

}
