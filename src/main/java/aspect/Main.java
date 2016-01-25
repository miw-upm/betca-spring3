package aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.enterprise.AspectConfig;
import aspectTarget.ServiceOne;

public final class Main {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        ServiceOne serviceOne = context.getBean(ServiceOne.class);
        serviceOne.method();
        serviceOne.argOneString("cadena");
        serviceOne.returnInt();
        try {
            serviceOne.exception();
        } catch (Exception e) {
        }
        serviceOne.annotation();
        ((AbstractApplicationContext) context).close();
    }
}
