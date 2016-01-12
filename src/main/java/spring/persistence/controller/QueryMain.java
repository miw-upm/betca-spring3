package spring.persistence.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.configuration.SpringConfigurationController;

public final class QueryMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationController.class);
        System.out.println("----------ooo----------");
        context.getBean(JpaRepositoryController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(QueryMethodsController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(QueryJPQLController.class).process();
        System.out.println("----------ooo----------");
        context.getBean(MethodsImplementationController.class).process();
        System.out.println("----------ooo----------");
        
        ((AbstractApplicationContext) context).close();
    }
}
