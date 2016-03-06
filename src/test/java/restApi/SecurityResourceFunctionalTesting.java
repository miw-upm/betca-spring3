package restApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;

import config.TestsApiConfig;
import restApi.Uris;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestsApiConfig.class})
// @TestPropertySource(locations = "classpath:test.properties")
public class SecurityResourceFunctionalTesting {

    private static final String url = "http://localhost:8080/JEE.Spring.0.0.1-SNAPSHOT/api/v0";

    // private static final String url = "http://art83.etsisi.upm.es/JEE.Spring.0.0.1-SNAPSHOT/api/v0";

    @Test
    public void testAdminOK() {
        String response = new RestBuilder<String>(url).path(Uris.SECURITY).path(Uris.ADMIN).basicAuth("admin", "123456")
                .clazz(String.class).get().build();
        System.out.println("INFO >>>>> " + response);
    }

    @Test
    public void testManagerOK() {
        String response = new RestBuilder<String>(url).path(Uris.SECURITY).path(Uris.MANAGER).basicAuth("manager", "123456")
                .clazz(String.class).get().build();
        System.out.println("INFO >>>>> " + response);
    }

    @Test
    public void testAdminUnauthorizedPassError() {
        try {
            new RestBuilder<String>(url).path(Uris.SECURITY).path(Uris.ADMIN).basicAuth("admin", "kk").clazz(String.class).get().build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.UNAUTHORIZED, httpError.getStatusCode());
            System.out.println("ERROR >>>>> " + httpError.getMessage());
            System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
        }
    }

    @Test
    public void testAdminUnauthorizedUser() {
        try {
            String response = new RestBuilder<String>(url).path(Uris.SECURITY).path(Uris.ADMIN).basicAuth("user", "123456")
                    .clazz(String.class).get().build();
            System.out.println("INFO >>>>> " + response);
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.FORBIDDEN, httpError.getStatusCode());
            System.out.println("ERROR >>>>> " + httpError.getMessage());
            System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
        }
    }

    @Test
    public void testUserUnauthorizedNonUser() {
        try {
            String response = new RestBuilder<String>(url).path(Uris.SECURITY).path(Uris.USER).clazz(String.class).get().build();
            System.out.println("INFO >>>>> " + response);
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.UNAUTHORIZED, httpError.getStatusCode());
            System.out.println("ERROR >>>>> " + httpError.getMessage());
            System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
        }
    }

    @Test
    public void testManagerUnauthorizedUser() {
        try {
            String response = new RestBuilder<String>(url).path(Uris.SECURITY).path(Uris.MANAGER).basicAuth("user", "123456")
                    .clazz(String.class).get().build();
            System.out.println("INFO >>>>> " + response);
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.FORBIDDEN, httpError.getStatusCode());
            System.out.println("ERROR >>>>> " + httpError.getMessage());
            System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
        }
    }

}
