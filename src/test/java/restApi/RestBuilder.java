package restApi;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

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

    private Map<String, String> headerValues;

    private String authorization = null;

    private Object body = null;

    private MultiValueMap<String, String> params;

    private Class<T> clazz;

    private HttpMethod method;

    public RestBuilder(String serverUri) {
        this.uri = serverUri;
        headerValues = new HashMap<>();
        params = new HttpHeaders();
    }

    public RestBuilder<T> path(String path) {
        this.uri = this.uri + path;
        return this;
    }

    public RestBuilder<T> authorization(String authorizationValue) {
        this.authorization = authorizationValue;
        return this;
    }

    public RestBuilder<T> basicAuth(String nick, String pass) {
        String auth = nick + ":" + pass;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + encodedAuth;
        this.authorization = authHeader;
        return this;
    }

    public RestBuilder<T> param(String key, String value) {
        this.params.add(key, value);
        return this;
    }

    public RestBuilder<T> header(String key, String value) {
        this.headerValues.put(key, value);
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
        for (String key : headerValues.keySet()) {
            headers.set(key, headerValues.get(key));
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

    public RestBuilder<T> post() {
        this.method = HttpMethod.POST;
        return this;
    }

    public RestBuilder<T> get() {
        this.method = HttpMethod.GET;
        return this;
    }

    public RestBuilder<T> put() {
        this.method = HttpMethod.PUT;
        return this;
    }

    public RestBuilder<T> patch() {
        this.method = HttpMethod.PATCH;
        return this;
    }

    public RestBuilder<T> delete() {
        this.method = HttpMethod.DELETE;
        return this;
    }
    
    public T build() {
        if (body != null && !method.equals(HttpMethod.GET)) {
            return restTemplate.exchange(this.uri(), method, new HttpEntity<Object>(body, this.headers()), clazz).getBody();
        } else {
            return restTemplate.exchange(this.uri(), method, new HttpEntity<Object>(this.headers()), clazz).getBody();
        }
    }

}
