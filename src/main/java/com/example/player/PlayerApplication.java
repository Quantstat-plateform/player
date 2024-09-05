package com.example.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerApplication.class, args);
    }

}
