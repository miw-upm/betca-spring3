package spring.persistence.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.configuration.SpringConfigurationController;

public final class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationController.class);
        ControllerE1 controller = context.getBean("controllerE1", ControllerE1.class);
        controller.process();
        ((AbstractApplicationContext) context).close();
    }
}
