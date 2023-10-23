package com.example.thyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ThymeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeApplication.class, args);
	}

}
