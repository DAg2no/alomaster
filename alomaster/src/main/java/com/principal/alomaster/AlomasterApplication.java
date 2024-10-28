package com.principal.alomaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.principal.alomaster") // Esta línea podría no ser necesaria
public class AlomasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlomasterApplication.class, args);
    }

}
