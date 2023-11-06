package com.reis.paquimetro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.reis", "com.reis.paquimetro", "com.reis.paquimetro.mapper"})
@SpringBootApplication
public class PaquimetroApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaquimetroApplication.class, args);
    }

}
