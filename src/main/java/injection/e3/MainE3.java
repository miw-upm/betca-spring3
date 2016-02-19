package injection.e3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class MainE3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/e3Config.xml"});
        MessageManager manager = context.getBean(MessageManager.class);
        manager.addMessage("1","uno");
        System.out.println(manager.findMessage("1"));
        ((AbstractApplicationContext) context).close();
    }
}
