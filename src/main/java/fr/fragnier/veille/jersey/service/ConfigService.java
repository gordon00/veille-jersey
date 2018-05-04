package fr.fragnier.veille.jersey.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigService {

    @Value("${cogit.value}")
    private String cogitValue;

    public String toto() {
        return cogitValue;
    }
}
