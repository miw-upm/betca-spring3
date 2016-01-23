package spring.injection.annotation.e2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    @Autowired
    private MessageService messageService1;

    //Es una instancia diferente a la anterior
    @Autowired
    private MessageService messageService2;

    public MessagePrinter() {
        // La inyeccción todavía no esta realizada
    }
    
    @PostConstruct
    public void postConstruct(){
        messageService1.setPrefix("1:");
        messageService2.setPrefix("2:");
    }

    public void print() {
        System.out.println(messageService1.message());
        System.out.println(messageService2.message());
    }
    
    @PreDestroy
    public void preDestroy(){
        System.out.println("liberando a printer...");
    }

}
