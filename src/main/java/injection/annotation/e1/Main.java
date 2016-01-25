package injection.annotation.e1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.start.AnnotationE1Config;

public final class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationE1Config.class);
        MessageManager manager = context.getBean(MessageManager.class);
        manager.addMessage("1","uno");
        System.out.println(manager.findMessage("1"));
        ((AbstractApplicationContext) context).close();
    }
}
