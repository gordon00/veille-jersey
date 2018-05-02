package fr.fragnier.veille.jersey.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Admettons que notre application nécessite Internet pour fonctionner...
 */
@Component
@ConditionalOnProperty("app.custom.actuator.health.internetConnectivity.checkUrl")
public class InternetConnectivityHealthIndicator implements HealthIndicator {

    private static final Logger LOG = LoggerFactory.getLogger(InternetConnectivityHealthIndicator.class);

    @Value("${app.custom.actuator.health.internetConnectivity.checkUrl}")
    private String checkUrl;

    @Override
    public Health health() {

        RestTemplate restTemplate = new RestTemplate();
        LOG.info("Checking if server can access to " + checkUrl);
        final long startTime = System.currentTimeMillis();
        try {

            final ResponseEntity<String> response = restTemplate.getForEntity(checkUrl, String.class);
            long elapsed = System.currentTimeMillis() - startTime;
            if(response.getStatusCode().is2xxSuccessful()) {
                return new Health.Builder().up()
                        .withDetail("checkUrl", checkUrl)
                        .withDetail("httpStatusCode", response.getStatusCode())
                        .withDetail("requestDuration", elapsed).build();
            } else {
                return new Health.Builder().down()
                        .withDetail("checkUrl", checkUrl)
                        .withDetail("httpStatusCode", response.getStatusCode())
                        .withDetail("requestDuration", elapsed)
                        .build();
            }
        } catch (Exception e) {
            return new Health.Builder().down().withException(e)
                    .withDetail("checkUrl", checkUrl)
                    .withDetail("requestDuration", System.currentTimeMillis() - startTime)
                    .build();
        }
    }
}
