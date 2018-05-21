package com.projeto.armazem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ArmazemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArmazemApplication.class, args);
    }
}
