package fr.fragnier.veille.jersey.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentService {

    @Autowired
    private Environment environment;

    public String[] getActiveProfiles() {
        return environment.getActiveProfiles();
    }
}
