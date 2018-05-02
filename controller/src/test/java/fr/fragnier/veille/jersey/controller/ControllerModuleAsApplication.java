package fr.fragnier.veille.jersey.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ControllerModuleConfig.class)
public class ControllerModuleAsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerModuleAsApplication.class, args);
    }
}
