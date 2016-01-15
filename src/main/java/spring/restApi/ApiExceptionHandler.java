package spring.restApi;

import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import spring.restApi.exceptions.ApiException;
import spring.restApi.exceptions.MalformedHeaderException;
import spring.restApi.exceptions.UnauthorizedException;
import spring.restApi.exceptions.UserIdNotExistException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserIdNotExistException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(ApiException exception) {
        ErrorMessage apiErrorMessage = new ErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: NOT_FOUND, " + apiErrorMessage);
        return apiErrorMessage;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnauthorizedException.class})
    public void unauthorized(ApiException exception) {
        ErrorMessage apiErrorMessage = new ErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: UNAUTHORIZED, " + apiErrorMessage);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MalformedHeaderException.class})
    @ResponseBody
    public ErrorMessage badRequest(ApiException exception) {
        ErrorMessage apiErrorMessage = new ErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: BAD_REQUEST, " + apiErrorMessage);
        return new ErrorMessage(exception);
    }

}
