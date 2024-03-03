package app.fitnessapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class })
public class FitnessAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(FitnessAppApplication.class, args);
    }

}
