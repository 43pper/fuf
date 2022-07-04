package com.secag.fuf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
@RestController
public class FufApplication {

    Connection connection = null;
    @GetMapping("/message")
    public String message(){
        String mesStart;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://fuf-server.mysql.database.azure.com:3306/fuf?autoReconnect=true", "raexxzgeqi", "Fufadmin!1234");
            mesStart = connection.toString();
        } catch (SQLException e) {
            mesStart = "ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ";
        }
        return mesStart + "Artem siv na velosyped i pishov yistu kabachky";
    }

    public static void main(String[] args) {
        SpringApplication.run(FufApplication.class, args);
    }

}
