package injection.e3;

public class MessageManager {

    private MessageService messageService;

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void addMessage(String key, String message) {
        messageService.add(key, message);
    }

    public String findMessage(String key) {
        return messageService.message(key);
    }

}
