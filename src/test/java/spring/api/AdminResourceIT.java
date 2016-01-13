package spring.api;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.annotation.PostConstruct;

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
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import spring.api.uris.AdminUris;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApiTestConfiguration.class})
@TestPropertySource(locations = "classpath:test.properties")
public class AdminResourceIT {

    private String url;

    @Autowired
    private Environment environment;

    @PostConstruct
    private void postConstruct() {
        this.url = environment.getProperty("api.url") + environment.getProperty("api.resource");
    }

    @Test
    public void testStart() {
        URI uri = UriComponentsBuilder.fromHttpUrl(url + AdminUris.ADMINS + AdminUris.START).build().encode().toUri();
        String response = new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<String>(new HttpHeaders()), String.class)
                .getBody();
        assertEquals("OK. Servidor levantado", response);
    }

    @Test
    public void testEcho() {
        // Header
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", "toooken");

        // Params
        MultiValueMap<String, String> params = new HttpHeaders();
        params.add("param", "paaaaram");
        params.add("other", "ooooother");

        // Uri
        URI uri = UriComponentsBuilder.fromHttpUrl(url).path(AdminUris.ADMINS).path(AdminUris.ECHO).path("/666").queryParams(params).build()
                .encode().toUri();
        System.out.println("URI: " + uri);

        String response = new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<String>(headers), String.class).getBody();
        System.out.println("Response: " + response);
    }
}
