package com.enigma.koperasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KoperasiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KoperasiApplication.class, args);
	}

}
