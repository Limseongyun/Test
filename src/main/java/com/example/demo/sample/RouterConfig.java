package com.example.demo.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

	@Bean
	public RouterFunction<ServerResponse> routerExamle(SampleHandler sam){
		return RouterFunctions.route()
				.GET("/sample/{id}", sam::test)
				.GET("/thymeleaf/{}", sam::thymeleaf)
				.build();
	}
	
	
	RouterFunction<ServerResponse> route = RouterFunctions.route()
		    .GET("/hello-world", request -> ServerResponse.ok().bodyValue("Hello World")).build();


}
