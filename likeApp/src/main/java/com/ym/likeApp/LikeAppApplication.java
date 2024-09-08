package com.ym.likeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LikeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LikeAppApplication.class, args);
	}

}
