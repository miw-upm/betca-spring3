package injection.e1e2e4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.start.E1Config;

public final class MainE1 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(E1Config.class);
        MessageManager manager = context.getBean(MessageManager.class);
        manager.addMessage("1","uno");
        System.out.println(manager.findMessage("1"));
        ((AbstractApplicationContext) context).close();
    }
}
