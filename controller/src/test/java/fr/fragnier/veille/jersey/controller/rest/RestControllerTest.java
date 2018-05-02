package fr.fragnier.veille.jersey.controller.rest;

import fr.fragnier.veille.jersey.controller.ControllerModuleAsApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ControllerModuleAsApplication.class)
public class RestControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetApiHello() {
        String value = testRestTemplate.getForObject("/api/hello", String.class);
        Assert.assertEquals(value, "test value");
    }
}