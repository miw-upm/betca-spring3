package injection.e5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.E5Config;

public final class MainE5 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(E5Config.class);
        ExtendedMessageManager manager = context.getBean(ExtendedMessageManager.class);
        manager.addMessage1("1", "uno");
        System.out.println(">>> messageService1 (message(1)): " + manager.findMessage1("1"));
        System.out.println(">>> messageService1 (key(uno)): " + manager.findKey1("uno"));
        System.out.println(">>> messageService2 (message(1)): " + manager.findMessage2("1"));
        ((AbstractApplicationContext) context).close();
    }
}
