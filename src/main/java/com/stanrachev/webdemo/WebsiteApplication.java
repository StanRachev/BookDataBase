package com.stanrachev.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

record Greeting(long id, String content) {}

@SpringBootApplication
@RestController
public class WebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteApplication.class, args);
	}

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting") // tells Spring to use the "greeting" method to answer requests
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) { //
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	} // @RequestParam tells Spring to expect a name in the request, if not use "World" by default
}
