package spring.restApi.exceptions;

public class MalformedHeaderException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Error de Authorization en cabecera por formato erroneo, debe estar en Auth Basic";

    public static final int CODE = 666;

    public MalformedHeaderException() {
        this("");
    }

    public MalformedHeaderException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
