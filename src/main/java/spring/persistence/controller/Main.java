package spring.persistence.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.configuration.SpringConfigurationController;

public final class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationController.class);
        System.out.println("----------ooo----------");
        context.getBean("unRelatedController", UnRelatedController.class).process();
        System.out.println("----------ooo----------");
        context.getBean("unidirectionalOneToOneEmbeddedController", UnidirectionalOneToOneEmbeddedController.class).process();
        System.out.println("----------ooo----------");
        context.getBean("unidirectionalOneToOneController", UnidirectionalOneToOneController.class).process();
        System.out.println("----------ooo----------");
        context.getBean("unidirectionalManyToOneController", UnidirectionalManyToOneController.class).process();
        System.out.println("----------ooo----------");
        context.getBean("unidirectionalOneToManyEmbeddedController", UnidirectionalOneToManyEmbeddedController.class).process();
        System.out.println("----------ooo----------");
        ((AbstractApplicationContext) context).close();
    }
}
