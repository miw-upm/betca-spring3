package restApi;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import config.TestsApiConfig;
import restApi.Uris;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestsApiConfig.class})
public class BasicResourceFunctionalTesting {

    private static final String URL_API = "http://localhost:8080/SPRING.2.0.0-SNAPSHOT" + Uris.SERVLET_MAP + Uris.VERSION;

    @Test
    public void testState() {
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API + Uris.BASICS + Uris.VERSION).build().encode().toUri();
        RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);

        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);
        String response = responseEntity.getBody();

        System.out.println("Response: " + response);
        assertEquals("{\"version\":\"" + Uris.VERSION + "\"}", response);
    }

    @Test
    public void testStateRestBuilder() {
        String response = new RestBuilder<String>(URL_API).path(Uris.BASICS).path(Uris.VERSION).clazz(String.class).get().build();

        System.out.println("Response: " + response);
        assertEquals("{\"version\":\"" + Uris.VERSION + "\"}", response);
    }

}
