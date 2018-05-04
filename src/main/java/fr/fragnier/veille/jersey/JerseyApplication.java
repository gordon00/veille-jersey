package fr.fragnier.veille.jersey;

import fr.fragnier.veille.jersey.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class JerseyApplication extends SpringBootServletInitializer {

    @Autowired
    private ConfigService configService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JerseyApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JerseyApplication.class, args);
    }
}
