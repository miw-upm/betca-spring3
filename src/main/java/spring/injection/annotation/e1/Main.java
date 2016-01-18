package spring.injection.annotation.e1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.config.test.AnnotationE1Config;

public final class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationE1Config.class);
        MessagePrinter printer = context.getBean("messagePrinter", MessagePrinter.class);
        printer.print();
        printer.print();
        ((AbstractApplicationContext) context).close();
    }
}
