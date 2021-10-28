package com.example.demo.sample;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class Handler {
	public Mono<ServerResponse> test(ServerRequest reqst){
		return ServerResponse.ok().bodyValue("hizz");
	}
}
