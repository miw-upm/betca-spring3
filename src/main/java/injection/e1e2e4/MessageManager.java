package injection.e1e2e4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageManager {

    private static final int YEAR = 2016;

    private MessageService messageService1;

    private MessageService messageService2;

    // Se inyecta un objeto de la clase indicada
    // @Autowired(required = true) por defecto
    // @Qualifier("messageService") Se inyecta un objeto del tipo indicado
    @Autowired
    public void setMessageService1(MessageService messageService1) {
        this.messageService1 = messageService1;
    }

    @Autowired
    public void setMessageService2(MessageService messageService2) {
        this.messageService2 = messageService2;
    }

    public void addMessage(String key, String message) {
        messageService1.add(key, message + "(" + YEAR + ")");
    }

    public String findMessage(String key) {
        return messageService2.message(key);
    }

}
