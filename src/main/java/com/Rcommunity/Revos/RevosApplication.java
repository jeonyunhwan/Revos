package com.Rcommunity.Revos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("")
public class RevosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevosApplication.class, args);
	}

}
