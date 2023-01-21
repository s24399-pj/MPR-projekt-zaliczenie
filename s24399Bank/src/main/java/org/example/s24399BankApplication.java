package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
@RestController
public class s24399BankApplication {
    public static void main(String[] args) {
        SpringApplication.run(s24399BankApplication.class, args);
    }

    @RequestMapping("/")
    public String mainPage() {
        return "Welcome in our bank !";
    }
}