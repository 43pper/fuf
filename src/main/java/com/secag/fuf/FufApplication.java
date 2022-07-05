package com.secag.fuf;

import com.secag.fuf.db.entitites.User;
import com.secag.fuf.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class FufApplication {
    @Autowired
    UserRepository userRepository;
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
