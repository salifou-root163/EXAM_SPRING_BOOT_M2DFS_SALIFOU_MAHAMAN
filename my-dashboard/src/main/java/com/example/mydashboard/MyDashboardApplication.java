package com.example.mydashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class MyDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDashboardApplication.class, args);
	}

}
