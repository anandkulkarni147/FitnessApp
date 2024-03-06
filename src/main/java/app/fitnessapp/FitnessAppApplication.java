package app.fitnessapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages={
        "app.fitnessapp.controller", "app.fitnessapp.model", "app.fitnessapp.repository",
        "app.fitnessapp.service"})
public class FitnessAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(FitnessAppApplication.class, args);
    }

}
