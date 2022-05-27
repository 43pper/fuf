package com.secag.fuf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FufApplication {

    @GetMapping("/message")
    public String message(){
        return "Artem siv na velosyped i pishov yistu kabachky";
    }

    public static void main(String[] args) {
        SpringApplication.run(FufApplication.class, args);
    }

}
