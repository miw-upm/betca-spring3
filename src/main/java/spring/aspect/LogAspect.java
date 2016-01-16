package spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Before("allMethodsPackage()")
    public void adviceA(JoinPoint jp) {
        System.out.println("=== Consejo Antes de ejecutar a metodos de un paquete:" + jp.getSignature().getName());
    }

    @Before("execution(* me*(..))")
    public void adviceB(JoinPoint jp) {
        System.out.println("=== Consejo Antes de ejecutar a metodos que empienzan por me*:" + jp.getSignature().getName());
    }

    @Before("args(name)")
    public void adviceC(JoinPoint jp, Object name) {
        System.out.println("=== Consejo Antes de ejecutar metodos con el argumento name:" + jp.getSignature().getName() + "(name):" + name);
    }

    @Before("@target(spring.aspect.GenericAnnotation)")
    public void adviceD(JoinPoint jp) {
        System.out.println("=== Consejo Antes de ejecutar metodos de una clase con GenericAnnotation:" + jp.getSignature().getName());
    }

    @Before("@annotation(spring.aspect.MethodAnnotation)")
    public void adviceE(JoinPoint jp) {
        System.out.println("=== Consejo Antes de ejecutar metodos con MethodAnnotation:" + jp.getSignature().getName());
    }

    @AfterReturning(pointcut = "allMethods()", returning = "result")
    public void adviceF(JoinPoint jp, int result) {
        System.out.println("=== Consejo Despues de ejecutar metodos que devuelven un int:" + jp.getSignature().getName() + " return:"
                + result);
    }

    @AfterThrowing(pointcut = "allMethods()", throwing = "exception")
    public void consejoJ(JoinPoint jp, Exception exception) {
        System.out.println("=== Consejo Despues de ejecutar metodos que provocan una Exception:" + jp.getSignature().getName() + " return:"
                + exception);
    }

    @After("execution(* spring.aspectTarget.ServiceOne.exception())")
    public void consejoJ(JoinPoint jp) {
        System.out.println("=== Consejo Despues de ejecutar metodos (finally):" + jp.getSignature().getName());
    }

    @Around("execution(* spring.aspectTarget.ServiceOne.method())")
    public Object consejoE(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("=== antes......");
        Object obj = pjp.proceed();
        System.out.println("=== ......despues");
        return obj;
    }

    @Pointcut("execution(* * (..))")
    public void allMethods() {
    }

    @Pointcut("execution(public * *(..))")
    public void allMethodsPublic() {
    }

    @Pointcut("execution(* spring.aspectTarget.*.* (..))")
    public void allMethodsPackage() {
    }

    @Pointcut("within(spring.aspectTarget.*)")
    public void allMethodsInPackage() {
    }

    @Pointcut("within(spring.aspectTarget..*)")
    public void allMethodsInPackageAndSubPackage() {
    }
}
