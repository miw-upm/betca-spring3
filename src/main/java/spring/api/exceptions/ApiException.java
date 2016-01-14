package spring.api.exceptions;

public class ApiException extends Exception {
    private static final long serialVersionUID = 1613504205825647750L;

    private static final String baseUrl = "Http://developer.server.com/exceptions/";

    private String url;

    public ApiException(String description, int code) {
        super(description);
        this.url = baseUrl + code;
    }

    public String getUrl() {
        return url;
    }

}
