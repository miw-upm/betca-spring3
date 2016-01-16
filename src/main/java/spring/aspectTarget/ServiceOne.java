package spring.aspectTarget;

import org.springframework.stereotype.Controller;

import spring.aspect.GenericAnnotation;
import spring.aspect.MethodAnnotation;

@Controller
@GenericAnnotation
public class ServiceOne {

    public void method() {
        System.out.println("-----------------> ServiceOne:method");
    }

    public void argName(String name) {
        System.out.println("-----------------> ServiceOne:argName(name=" + name + ")");
    }

    public void argString(String other) {
        System.out.println("-----------------> ServiceOne:argString(other=" + other + ")");
    }

    public int returnInt() {
        int result = 666;
        System.out.println("-----------------> ServiceOne:returnInt return= " + result);
        return result;
    }

    public void exception() throws Exception {
        System.out.println("-----------------> ServiceOne:exception");
        throw new Exception(">:o(");
    }

    @MethodAnnotation
    public void annotation() {
        System.out.println("-----------------> ServiceOne:annotation");
    }

}
