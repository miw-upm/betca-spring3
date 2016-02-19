package injection.e3;

public class MessageManager {

    private static final int YEAR = 2016;

    private MessageService messageService;

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void addMessage(String key, String message) {
        messageService.add(key, message + "(" + YEAR + ")");
    }

    public String findMessage(String key) {
        return messageService.message(key);
    }

}
