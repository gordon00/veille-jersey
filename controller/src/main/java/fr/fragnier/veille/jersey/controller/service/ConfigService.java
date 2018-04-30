package fr.fragnier.veille.jersey.controller.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigService {

    @Value("${cogit.value}")
    private String cogitValue;

    public String getCogitValue() {
        return cogitValue;
    }
}
