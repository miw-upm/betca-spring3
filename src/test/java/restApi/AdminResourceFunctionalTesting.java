package restApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URI;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import config.TestsApiConfig;
import restApi.Gender;
import restApi.Uris;
import restApi.Wrapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestsApiConfig.class})
public class AdminResourceFunctionalTesting {

    private static final String URL_API = "http://localhost:8080/JEE.Spring.0.0.1-SNAPSHOT" + Uris.SERVLET_MAP;

    @Test
    public void testState() {
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API + Uris.ADMINS + Uris.STATE).build().encode().toUri();
        RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);

        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);
        String response = responseEntity.getBody();

        System.out.println("Response: " + response);
        assertEquals("{\"response\":\"OK " + Uris.VERSION + "\"}", response);
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
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.ECHO).path(Uris.ID).queryParams(params)
                .buildAndExpand(666).encode().toUri();
        System.out.println("URI: " + uri);

        RequestEntity<Object> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        String response = new RestTemplate().exchange(requestEntity, String.class).getBody();
        System.out.println("Response: " + response);
        assertEquals("{\"id\":666,\"token\":\"toooken\",\"param\":\"paaaaram\"}", response);
    }

    @Test
    public void testBodyWrapper() {
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.BODY).build().encode().toUri();
        Wrapper wrapper = new Wrapper(666, "daemon", Gender.FEMALE, new GregorianCalendar(1979, 07, 22));

        RequestEntity<Wrapper> requestEntity = new RequestEntity<>(wrapper, HttpMethod.POST, uri);

        String json = new RestTemplate().exchange(requestEntity, String.class).getBody();
        System.out.println(json);
        Wrapper response = new RestTemplate().exchange(requestEntity, Wrapper.class).getBody();
        System.out.println(response);
    }

    @Test
    public void testBodyStringList() {
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.BODY).path(Uris.STRING_LIST).build().encode()
                .toUri();
        String json = new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), String.class).getBody();
        System.out.println(json);
        List<String> response = Arrays.asList(new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()),
                String[].class).getBody());
        System.out.println(response);
    }

    @Test
    public void testBodyWrapperList() {
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.BODY).path(Uris.WRAPPER_LIST).build().encode()
                .toUri();
        String json = new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), String.class).getBody();
        System.out.println(json);
        List<Wrapper> response = Arrays.asList(new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()),
                Wrapper[].class).getBody());
        System.out.println(response);
    }

    @Test
    public void testErrorNotToken() {
        try {
            new RestBuilder<Wrapper>(URL_API).path(Uris.ADMINS).path(Uris.ERROR).path("/66").get().build();
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
            new RestBuilder<Wrapper>(URL_API).path(Uris.ADMINS).path(Uris.ERROR).path("/66").header("token", "kk").get().build();
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
            new RestBuilder<Wrapper>(URL_API).path(Uris.ADMINS).path(Uris.ERROR).path("/66").header("token", "Basic kk").get().build();
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
            new RestBuilder<Wrapper>(URL_API).path(Uris.ADMINS).path(Uris.ERROR).path("/0").header("token", "Basic good").get().build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.NOT_FOUND, httpError.getStatusCode());
            System.out.println("ERROR >>>>> " + httpError.getMessage());
            System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
        }
    }

    @Test
    public void testErrorOk() {
        Wrapper response = new RestBuilder<Wrapper>(URL_API).path(Uris.ADMINS).path(Uris.ERROR).path("/666").header("token", "Basic good")
                .clazz(Wrapper.class).get().build();
        System.out.println("INFO >>>>> " + response);
    }

    @Test
    public void testSecurityAnnotationOk() {
        String response = new RestBuilder<String>(URL_API).path(Uris.ADMINS).path(Uris.SECURITY).basicAuth("admin", "123456")
                .clazz(String.class).get().build();
        System.out.println("INFO >>>>> " + response);
    }

    @Test
    public void testSecurityAnnotationForbidden() {
        try {
            new RestBuilder<String>(URL_API).path(Uris.ADMINS).path(Uris.SECURITY).basicAuth("user", "123456").clazz(String.class).get()
                    .build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.FORBIDDEN, httpError.getStatusCode());
            System.out.println("ERROR >>>>> " + httpError.getMessage());
            System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
        }
    }
    
    @Test
    public void testSecurityAnnotationUnauthorized() {
        try {
            new RestBuilder<String>(URL_API).path(Uris.ADMINS).path(Uris.SECURITY).basicAuth("user", "kkk").clazz(String.class).get()
                    .build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.UNAUTHORIZED, httpError.getStatusCode());
            System.out.println("ERROR >>>>> " + httpError.getMessage());
            System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
        }
    }
}
