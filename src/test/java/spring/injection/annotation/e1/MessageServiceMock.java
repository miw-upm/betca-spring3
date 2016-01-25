package spring.injection.annotation.e1;

import injection.annotation.e1.MessageService;

public class MessageServiceMock extends MessageService {

    private String key;

    private String message;

    @Override
    public void add(String key, String message) {
        this.key = key;
        this.message = message;
    }

    @Override
    public String message(String key) {
        return message;
    }

    @Override
    public String key(String message) {
        return key;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
