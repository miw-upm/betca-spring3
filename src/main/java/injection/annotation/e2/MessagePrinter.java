package injection.annotation.e2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    @Autowired
    private ExtendedMessageService messageService1;

    // Es una instancia diferente a la anterior por ser "prototype"
    @Autowired
    private ExtendedMessageService messageService2;

    public MessagePrinter() {
        // La inyeccción todavía no esta realizada
    }
    
    @PostConstruct
    public void postConstruct(){
        messageService1.setPrefix("prefix");
    }

    public void print() {
        messageService1.add("1", "uno");
        System.out.println(">>> messageService1 (message(1)): " + messageService1.message("1"));
        System.out.println(">>> messageService1 (key(uno)): " + messageService1.key("uno"));
        System.out.println(">>> messageService2 (message(1)): " + messageService2.message("1"));
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("liberando a printer...");
    }

}
