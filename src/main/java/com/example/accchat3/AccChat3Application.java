package com.example.accchat3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AccChat3Application {

	public static void main(String[] args) {
		SpringApplication.run(AccChat3Application.class, args);
	}

}
