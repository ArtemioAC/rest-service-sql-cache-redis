package com.lab.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InformationDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationDataServiceApplication.class, args);
	}

}
