package fr.fragnier.veille.jersey.controller.rest;

import fr.fragnier.veille.jersey.controller.model.HelloDto;
import fr.fragnier.veille.jersey.controller.service.ConfigService;
import fr.fragnier.veille.jersey.controller.service.EnvironmentService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
public class RestController {

    @Autowired
    private ConfigService configService;

    @Autowired
    private EnvironmentService environmentService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return configService.getCogitValue();
    }

    @GET
    @Path("env")
    @Produces(MediaType.TEXT_PLAIN)
    public String getEnv() {
        StringBuilder sb = new StringBuilder();

        final String[] activeProfiles = environmentService.getActiveProfiles();
        if(activeProfiles.length > 0) {
            sb.append("Profiles actifs : ");
            for (String env : activeProfiles) {
                sb.append(env).append(" ");
            }
        }

        sb.append("\n");

        final List<String> propNames = new ArrayList<>();
        propNames.add("cogit.value");
        propNames.add("cogit.secondValue");

        for(String propName : propNames) {
            sb.append(propName).append(" --> ").append(environmentService.getProperty(propName)).append("\n");
        }

        return sb.toString();
    }

    @Path("world")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HelloDto toto() {
        final HelloDto helloDto = new HelloDto();
        helloDto.setName("Simpson");
        helloDto.setSurname("Homer");
        helloDto.setBirthDate(new LocalDate(1956, 10, 10));
        return helloDto;
    }
}
