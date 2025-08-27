package com.mysite.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbbApplication {

	MainController mainController = new MainController();

	public static void main(String[] args) {
		SpringApplication.run(SbbApplication.class, args);
	}

}
