package spring.api;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import spring.api.uris.AdminUris;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApiTestConfiguration.class})
@TestPropertySource(locations = "classpath:test.properties")
public class AdminResourceIT {

    @Autowired
    private Environment environment;

    @Test
    public void testStart() {
        String url = environment.getProperty("api.url") + environment.getProperty("api.resource") + AdminUris.ADMINS + AdminUris.START;
        URI uri = UriComponentsBuilder.fromHttpUrl(url).build().encode().toUri();
        String response = new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<String>(new HttpHeaders()), String.class)
                .getBody();
        assertEquals("OK. Servidor levantado", response);
    }
}
