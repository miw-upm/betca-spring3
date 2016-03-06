package restApi;

import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import restApi.exceptions.MalformedHeaderException;
import restApi.exceptions.UnauthorizedException;
import restApi.exceptions.NotFoundUserIdException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundUserIdException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: NOT_FOUND, " + errorMessage);
        return errorMessage;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnauthorizedException.class})
    public void unauthorized(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: UNAUTHORIZED, " + errorMessage);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MalformedHeaderException.class})
    @ResponseBody
    public ErrorMessage badRequest(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception);
        LogManager.getLogger(this.getClass()).info("  ERROR: BAD_REQUEST, " + errorMessage);
        return new ErrorMessage(exception);
    }

    
}
