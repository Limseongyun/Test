package com.example.demo.sample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {

	@GetMapping("/test")
	public String test() {
		log.debug("test");
		return "test123";
	}
}
