package fr.fragnier.veille.jersey.rest;

import fr.fragnier.veille.jersey.model.HelloDto;
import fr.fragnier.veille.jersey.service.ConfigService;
import fr.fragnier.veille.jersey.service.EnvironmentService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class RestController {

    @Autowired
    private ConfigService configService;

    @Autowired
    private EnvironmentService environmentService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return configService.toto();
    }

    @GET
    @Path("env")
    @Produces(MediaType.TEXT_PLAIN)
    public String getEnv() {
        StringBuilder sb = new StringBuilder();
        sb.append("Profiles actifs : ");
        for(String env : environmentService.getActiveProfiles()) {
            sb.append(env).append(" ");
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
