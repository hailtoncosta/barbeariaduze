package com.app.barbeariaduze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
@EnableWebMvc
public class BarbeariaduzeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbeariaduzeApplication.class, args);
		
	}

}
