package spring.config.start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.injection.annotation.e1.MessageManager;
import spring.injection.annotation.e1.MessageService;

@Configuration
public class AnnotationE1BConfig {
    
    //<bean id="messageService" class="spring.injection.e1.MessageService" />
    @Bean
    public MessageService messageService() {
        return new MessageService();
    }
    
    //<bean id="messagePrinter" class="spring.injection.e1.MessagePrinter">
    @Bean
    public MessageManager messagePrinter() {
        return new MessageManager();
    }
    
}
