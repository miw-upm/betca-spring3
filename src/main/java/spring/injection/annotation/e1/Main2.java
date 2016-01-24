package spring.injection.annotation.e1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.config.start.AnnotationE1BConfig;

public final class Main2 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationE1BConfig.class);
        MessageManager manager = context.getBean(MessageManager.class);
        manager.addMessage("1","uno");
        System.out.println(manager.findMessage("1"));
        ((AbstractApplicationContext) context).close();
    }
}
