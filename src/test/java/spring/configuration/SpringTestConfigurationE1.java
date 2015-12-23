package spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.injection.annotation.e1.MessageService;
import spring.injection.annotation.e1.MessageServiceMock;

@Configuration
@ComponentScan(basePackages = "spring.injection.annotation.e1")
public class SpringTestConfigurationE1 {
    
    @Bean
    public MessageService messageService() {
        return new MessageServiceMock();
    }

}