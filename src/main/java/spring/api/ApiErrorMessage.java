package spring.api;

import spring.api.exceptions.ApiException;

public class ApiErrorMessage {

    private String error;

    private String description;

    private String url;

    public ApiErrorMessage(ApiException exception) {
        this(exception.getClass().getSimpleName(), exception.getMessage(), exception.getUrl());
    }

    public ApiErrorMessage(String error, String description, String url) {
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
