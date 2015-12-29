package spring.persistence.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.configuration.SpringConfigurationController;

public final class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationController.class);
        System.out.println("----------ooo----------");
        context.getBean(UnRelatedController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(UnidirectionalOneToOneEmbeddedController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(UnidirectionalOneToOneJoinColumnController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(UnidirectionalManyToOneJoinColumnController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(UnidirectionalOneToManyEmbeddedController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(UnidirectionalOneToManyController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(BidirectionalOneToOneEmbeddedController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(BidirectionalOneToOneJoinColumnController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(BidirectionalOneToOneMappedByController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(BidirectionalManyToOneJoinColumnController.class).process();
        System.out.println("----------ooo----------");
        ((AbstractApplicationContext) context).close();
    }
}
