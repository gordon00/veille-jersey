package fr.fragnier.veille.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        this.packages(JerseyApplication.class.getPackage().getName());
    }
}
