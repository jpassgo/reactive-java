package com.pascoe.reactivelearnings.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.xml.ws.ServiceMode;

import static org.springframework.web.reactive.function.client.WebClient.*;

public class RedirectFilter implements GlobalFilter {

    WebClient webClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Mono<ResponseSpec> initialExchange = buildExchange(exchange);
        Mono<ResponseSpec> onErrorExchange = buildExchange(exchange);
        return initialExchange
                .onErrorResume((error) -> {
                    return onErrorExchange;
                })
                .then(chain.filter(exchange));
    }

    Mono<ResponseSpec> buildExchange(ServerWebExchange exchange) {
        return Mono.error(Exception::new);
    }

}
