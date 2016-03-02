package persistence.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.ControllerConfig;

public final class RelationMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ControllerConfig.class);
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
        context.getBean(BidirectionalOneToManyMappedByController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(BidirectionalManyToManyController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(UnidirectionalManyToManyController.class).process();
        System.out.println("----------ooo----------");
        ((AbstractApplicationContext) context).close();
    }
}
