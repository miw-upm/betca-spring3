package spring.injection.xml;

public class MessagePrinter {

    private MessageService messageService;

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void print() {
        System.out.println(messageService.message());
    }
}
