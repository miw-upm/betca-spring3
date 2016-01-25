package injection.annotation.e1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main3 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("injection.annotation.e1");
        context.refresh();
        MessageManager manager = context.getBean(MessageManager.class);
        manager.addMessage("1","uno");
        System.out.println(manager.findMessage("1"));
        ((AbstractApplicationContext) context).close();
    }

}
