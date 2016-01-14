package spring.api;

import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import spring.api.exceptions.ApiException;
import spring.api.exceptions.MalformedHeaderException;
import spring.api.exceptions.UnauthorizedException;
import spring.api.exceptions.UserIdNotExistException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserIdNotExistException.class})
    @ResponseBody
    public ApiErrorMessage notFoundRequest(ApiException exception) {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: NOT_FOUND, " + apiErrorMessage);
        return apiErrorMessage;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnauthorizedException.class})
    public void unauthorized(ApiException exception) {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: UNAUTHORIZED, " + apiErrorMessage);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MalformedHeaderException.class})
    @ResponseBody
    public ApiErrorMessage badRequest(ApiException exception) {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: BAD_REQUEST, " + apiErrorMessage);
        return new ApiErrorMessage(exception);
    }

}
