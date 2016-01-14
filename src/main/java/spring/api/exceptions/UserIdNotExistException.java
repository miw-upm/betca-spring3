package spring.api.exceptions;

public class UserIdNotExistException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "No se encuentra el identificador de usuario utilizado";

    public static final int CODE = 333;

    public UserIdNotExistException() {
        this("");
    }

    public UserIdNotExistException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
