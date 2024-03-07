package app.fitnessapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(scanBasePackages={
        "app.fitnessapp.controller", "app.fitnessapp.model", "app.fitnessapp.repository",
        "app.fitnessapp.service"}, exclude = {SecurityAutoConfiguration.class })
@CrossOrigin(origins = "*")
public class FitnessAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(FitnessAppApplication.class, args);
    }

}
