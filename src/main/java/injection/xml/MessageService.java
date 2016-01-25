package injection.xml;

public class MessageService {

    private int i = 0;

    public String message() {
        return "Mensaje... " + i++;
    }
}
