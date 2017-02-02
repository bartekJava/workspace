package com.websystique.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.websystique.springboot"})
public class SpringBootStandAloneApp
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootStandAloneApp.class, args);
	}
}
