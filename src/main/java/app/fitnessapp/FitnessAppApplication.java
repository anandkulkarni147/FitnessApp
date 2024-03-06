package app.fitnessapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages={
        "app.fitnessapp.controller", "app.fitnessapp.model", "app.fitnessapp.repository",
        "app.fitnessapp.service"}, exclude = {SecurityAutoConfiguration.class })
public class FitnessAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(FitnessAppApplication.class, args);
    }

}
