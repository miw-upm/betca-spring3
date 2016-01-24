package spring.injection.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"springConfig.xml"});
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.print();
        printer.print();
        ((AbstractApplicationContext) context).close();
    }
}
