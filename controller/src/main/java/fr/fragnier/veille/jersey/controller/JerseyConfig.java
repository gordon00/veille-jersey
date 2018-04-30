package fr.fragnier.veille.jersey.controller;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        this.packages(JerseyConfig.class.getPackage().getName());
    }
}
