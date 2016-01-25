package injection.annotation.e1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component("messagePrinter") o @Component(value="messagePrinter")
@Component
public class MessageManager {

    private static final int YEAR = 2016;

    // Se inyecta un objeto de la clase indicada
    // @Autowired(required = true)
    // @Qualifier("messageService") Se inyecta un objeto del tipo indicado y con el tipo indicado
    @Autowired
    private MessageService messageService1;

    @Autowired
    private MessageService messageService2;

    public void addMessage(String key, String message) {
        messageService1.add(key, message + "(" + YEAR + ")");
    }

    public String findMessage(String key) {
        return messageService2.message(key);
    }

}
