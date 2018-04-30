package fr.fragnier.veille.jersey.controller;

import fr.fragnier.veille.jersey.controller.service.ConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ControllerModuleConfig.class)
public class JerseyApplicationTests {

    @Autowired
    private JerseyConfig jerseyConfig;

    @Autowired
    private ConfigService configService;


    // TODO test intégration controller rest avec end point
//    @Autowired
//    private RestController restController;

    @Test
    public void contextLoads() {
        jerseyConfig.equals(null);
    }

    @Test
    public void titi() {

    }

}
