package com.luv2code.SpringCoreDemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(
// 	scanBasePackages = {"com.luv2code.SpringCoreDemo",
// 						"com.luv2code.util"}
// )
@SpringBootApplication
public class SpringcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoreApplication.class, args);
	}

}
