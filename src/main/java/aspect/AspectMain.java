package aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AspectConfig;
import aspectTarget.ServiceOne;

public final class AspectMain {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        ServiceOne serviceOne = context.getBean(ServiceOne.class);
        serviceOne.method();
        serviceOne.argString("cadena");
        serviceOne.returnInt();
        try {
            serviceOne.exception();
        } catch (Exception e) {
            System.out.println(">>>Se procesa la exception");
        }
        serviceOne.annotation();
        ((AbstractApplicationContext) context).close();
    }
}
