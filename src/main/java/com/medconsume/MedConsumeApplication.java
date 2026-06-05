    package com.medconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedConsumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedConsumeApplication.class, args);
        System.out.println("\n Server is running at: http://localhost:8080/home\n");



    }
}
