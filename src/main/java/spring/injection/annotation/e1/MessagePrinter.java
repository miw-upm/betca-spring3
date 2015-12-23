package spring.injection.annotation.e1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//@Component("messagePrinter")
// (value="messagePrinter")
public class MessagePrinter {

    //Se inyecta un objeto del tipo indicado
    @Autowired//(required = true)
    //@Qualifier("messageService") Se inyecta un objeto del tipo indicado y con el indice indicado
    private MessageService messageService1;

    @Autowired
    private MessageService messageService2;

    public void print() {
        System.out.println(messageService1.message());
        System.out.println(messageService2.message());
    }

}
