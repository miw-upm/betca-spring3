package spring.injection.annotation.e1;

public class MessageServiceMock extends MessageService {

    @Override
    public String message() {
        return "mock";
    }

}
