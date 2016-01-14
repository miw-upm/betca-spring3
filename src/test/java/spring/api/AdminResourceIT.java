package spring.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URI;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
        URI uri = UriComponentsBuilder.fromHttpUrl(url).path(AdminUris.ADMINS).path(AdminUris.ECHO).path("/666").queryParams(params)
                .build().encode().toUri();
        System.out.println("URI: " + uri);

        String response = new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<String>(headers), String.class).getBody();
        System.out.println("Response: " + response);
    }

    @Test
    public void testBodyWrapper() {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).path(AdminUris.ADMINS).path(AdminUris.BODY).build().encode().toUri();
        Wrapper wrapper = new Wrapper(666, "daemon", Gender.FEMALE, new GregorianCalendar(1979, 07, 22));
        String json = new RestTemplate().exchange(uri, HttpMethod.POST, new HttpEntity<Object>(wrapper, new HttpHeaders()), String.class)
                .getBody();
        System.out.println(json);
        Wrapper response = new RestTemplate().exchange(uri, HttpMethod.POST, new HttpEntity<Object>(wrapper, new HttpHeaders()),
                Wrapper.class).getBody();
        System.out.println(response);
    }

    @Test
    public void testBodyStringList() {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).path(AdminUris.ADMINS).path(AdminUris.BODY).path(AdminUris.STRING_LIST).build()
                .encode().toUri();
        String json = new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), String.class).getBody();
        System.out.println(json);
        List<String> response = Arrays.asList(new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()),
                String[].class).getBody());
        System.out.println(response);
    }

    @Test
    public void testBodyWrapperList() {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).path(AdminUris.ADMINS).path(AdminUris.BODY).path(AdminUris.WRAPPER_LIST).build()
                .encode().toUri();
        String json = new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), String.class).getBody();
        System.out.println(json);
        List<Wrapper> response = Arrays.asList(new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()),
                Wrapper[].class).getBody());
        System.out.println(response);
    }

    @Test
    public void testErrorNotToken() {
        try {
            new RestBuilder<Wrapper>(url).path(AdminUris.ADMINS).path(AdminUris.ERROR).path("/66").get().build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.BAD_REQUEST, httpError.getStatusCode());
            System.out.println("ERROR>>>>> " + httpError.getMessage());
            System.out.println("ERROR>>>>> " + httpError.getResponseBodyAsString());
        }
    }

    @Test
    public void testErrorMalFormedToken() {
        try {
            new RestBuilder<Wrapper>(url).path(AdminUris.ADMINS).path(AdminUris.ERROR).path("/66").header("token", "kk").get().build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.BAD_REQUEST, httpError.getStatusCode());
            System.out.println("ERROR >>>>> " + httpError.getMessage());
            System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
        }
    }

    @Test
    public void testErrorNotExistToken() {
        try {
            new RestBuilder<Wrapper>(url).path(AdminUris.ADMINS).path(AdminUris.ERROR).path("/66").header("token", "Basic kk").get().build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.UNAUTHORIZED, httpError.getStatusCode());
            System.out.println("ERROR >>>>> " + httpError.getMessage());
            System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
        }
    }

    @Test
    public void testErrorNotExistId() {
        try {
            new RestBuilder<Wrapper>(url).path(AdminUris.ADMINS).path(AdminUris.ERROR).path("/0").header("token", "Basic good").get().build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.NOT_FOUND, httpError.getStatusCode());
            System.out.println("ERROR >>>>> " + httpError.getMessage());
            System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
        }
    }

    @Test
    public void testErrorOk() {
        Wrapper response = new RestBuilder<Wrapper>(url).path(AdminUris.ADMINS).path(AdminUris.ERROR).path("/666").header("token", "Basic good")
                .clazz(Wrapper.class).get().build();
        System.out.println("INFO >>>>> " + response);
    }

}
