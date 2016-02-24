package restApi.exceptions;

public class NotFoundUserIdException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "No se encuentra el identificador de usuario utilizado";

    public static final int CODE = 333;

    public NotFoundUserIdException() {
        this("");
    }

    public NotFoundUserIdException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
