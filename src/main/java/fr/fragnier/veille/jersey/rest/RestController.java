package fr.fragnier.veille.jersey.rest;

import fr.fragnier.veille.jersey.model.HelloDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/hello")
public class RestController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "helloworld";
    }

    @Path("world")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HelloDto toto() {
        final HelloDto helloDto = new HelloDto();
        helloDto.setName("Simpson");
        helloDto.setSurname("Homer");
        helloDto.setBirthDate(LocalDate.of(1956, 10, 10));
        return helloDto;
    }
}
