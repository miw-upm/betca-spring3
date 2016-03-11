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

    private static final String URL_API = "http://localhost:8080/JEE.Spring.0.0.1-SNAPSHOT" + Uris.SERVLET_MAP;

    @Test
    public void testState() {
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API + Uris.BASICS + Uris.STATE).build().encode().toUri();
        RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);

        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);
        String response = responseEntity.getBody();

        System.out.println("Response: " + response);
        assertEquals("{\"response\":\"OK " + Uris.VERSION + "\"}", response);
    }

}
