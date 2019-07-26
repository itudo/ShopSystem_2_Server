package com.yc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
@EnableEurekaClient
@RestController
public class AdminEurekaClient {
	
	public static void main(String[] args) {
        SpringApplication.run(AdminEurekaClient.class, args);
    }  
}
