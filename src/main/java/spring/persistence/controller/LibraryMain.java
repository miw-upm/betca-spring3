package spring.persistence.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.configurationMain.SpringConfigurationController;

public final class LibraryMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationController.class);
        System.out.println("----------ooo----------");
        context.getBean(LibraryController.class).process();
        System.out.println("----------ooo----------");
        ((AbstractApplicationContext) context).close();
    }
}
