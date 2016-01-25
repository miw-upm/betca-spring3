package restApi;

import restApi.exceptions.ApiException;

public class ErrorMessage {

    private String error;

    private String description;

    private String url;

    public ErrorMessage(ApiException exception) {
        this(exception.getClass().getSimpleName(), exception.getMessage(), exception.getUrl());
    }

    public ErrorMessage(String error, String description, String url) {
        this.error = error;
        this.description = description;
        this.url = url;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ApiErrorMessage [error=" + error + ", description=" + description + ", url=" + url + "]";
    }

}
