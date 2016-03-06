package restApi.exceptions;

public class UnauthorizedException extends Exception {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "La identificación utilizada no tiene la autoridad suficiente";

    public static final int CODE = 001;

    public UnauthorizedException() {
        this("");
    }

    public UnauthorizedException(String detail) {
        super(DESCRIPTION + ". " + detail + ". CODE: " + CODE);
    }

}
