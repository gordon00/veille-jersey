package fr.fragnier.veille.jersey.controller.rest;

import fr.fragnier.veille.jersey.controller.ControllerModuleAsApplication;
import fr.fragnier.veille.jersey.controller.service.ConfigService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ControllerModuleAsApplication.class)
public class RestControllerWithMockTest {

    @MockBean
    private ConfigService configService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetApiHello() {
        // GIVEN
        Mockito.reset(configService);
        Mockito.when(configService.getCogitValue()).thenReturn("tototiti");

        // WHEN
        String value = testRestTemplate.getForObject("/api/hello", String.class);

        // THEN
        Assert.assertEquals(value, "tototiti");
    }
}