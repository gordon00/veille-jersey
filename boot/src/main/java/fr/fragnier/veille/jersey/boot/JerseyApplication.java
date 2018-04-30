package fr.fragnier.veille.jersey.boot;


import fr.fragnier.veille.jersey.controller.ControllerModuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ControllerModuleConfig.class)
public class JerseyApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JerseyApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JerseyApplication.class, args);
    }
}
