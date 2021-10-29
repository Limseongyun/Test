package com.example.demo.sample;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class SampleHandler {

	public Mono<ServerResponse> test(ServerRequest request){
		log.debug("test handler");
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(request.pathVariable("id"));
	}
}
