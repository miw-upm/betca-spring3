package spring.api;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestBuilder<T> {

    private RestTemplate restTemplate = new RestTemplate();

    private String uri;

    private String headerKey = null;

    private String headerValue = "";

    private String token = null;

    private String authorization = null;

    private Object body = null;

    private MultiValueMap<String, String> params = new HttpHeaders();

    private Class<T> clazz;

    public RestBuilder(String serverUri) {
        this.uri = serverUri;
    }

    public RestBuilder<T> uri(String uri) {
        this.uri = this.uri + uri;
        return this;
    }

    public RestBuilder<T> headerKey(String headerKey) {
        this.headerKey = headerKey;
        return this;
    }

    public RestBuilder<T> headerValue(String headerValue) {
        this.headerValue = headerValue;
        return this;
    }

    public RestBuilder<T> token(String tokenValue) {
        this.token = tokenValue;
        return this;
    }

    public RestBuilder<T> authorization(String authorizationValue) {
        this.authorization = authorizationValue;
        return this;
    }

    public RestBuilder<T> authorization(String nick, String pass) {
        String auth = nick + ":" + pass;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + encodedAuth;
        this.authorization = authHeader;
        return this;
    }

    public RestBuilder<T> param(String name, String value) {
        this.params.add(name, value);
        return this;
    }

    public RestBuilder<T> body(Object body) {
        this.body = body;
        return this;
    }

    public RestBuilder<T> notError() {
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            protected boolean hasError(HttpStatus statusCode) {
                return false;
            }
        });
        return this;
    }

    public RestBuilder<T> clazz(Class<T> clazz) {
        this.clazz = clazz;
        return this;
    }

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        if (headerKey != null) {
            headers.set(headerKey, headerValue);
        }
        if (token != null) {
            headers.set("token", token);
        }

        if (authorization != null) {
            headers.set("Authorization", authorization);
        }
        return headers;
    }

    private URI uri() {
        if (params.isEmpty()) {
            return UriComponentsBuilder.fromHttpUrl(uri).build().encode().toUri();
        } else {
            return UriComponentsBuilder.fromHttpUrl(uri).queryParams(params).build().encode().toUri();
        }
    }

    private T httpMethod(HttpMethod method) {
        if (body == null) {
            return restTemplate.exchange(this.uri(), method, new HttpEntity<String>(this.headers()), clazz).getBody();
        } else {
            return restTemplate.exchange(this.uri(), method, new HttpEntity<Object>(body, this.headers()), clazz).getBody();
        }
    }

    public T get() {
        return this.httpMethod(HttpMethod.GET);
    }

    public T post() {
        return this.httpMethod(HttpMethod.POST);
    }

    public T delete() {
        return this.httpMethod(HttpMethod.DELETE);
    }

    public T put() {
        return this.httpMethod(HttpMethod.PUT);
    }
}
