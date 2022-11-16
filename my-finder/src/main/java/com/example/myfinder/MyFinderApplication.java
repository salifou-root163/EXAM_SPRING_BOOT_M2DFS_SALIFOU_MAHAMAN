package com.example.myfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableEurekaClient
@EnableHystrixDashboard
@EnableCircuitBreaker
public class MyFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFinderApplication.class, args);
	}

}
