package spring.injection.annotation.e1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component("messagePrinter") o @Component(value="messagePrinter")
@Component
public class MessagePrinter {

    // Se inyecta un objeto de la clase indicada
    // @Autowired(required = true)
    // @Qualifier("messageService") Se inyecta un objeto del tipo indicado y con el tipo indicado
    @Autowired
    private MessageService messageService1;

    @Autowired
    private MessageService messageService2;

    public void print() {
        System.out.println(messageService1.message());
        System.out.println(messageService2.message());
    }

}
