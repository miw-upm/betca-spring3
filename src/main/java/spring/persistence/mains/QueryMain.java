package spring.persistence.mains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.configuration.SpringConfigurationController;
import spring.persistence.controller.JpaRepositoryController;
import spring.persistence.controller.MethodsImplementationController;
import spring.persistence.controller.QueryJPQLController;
import spring.persistence.controller.QueryMethodsController;

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
