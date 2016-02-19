package config;

import injection.annotation.e1.MessageServiceMock;
import injection.e1e2e4.MessageService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "injection.annotation.e1")
public class TestsConfigE1 {
    
    @Bean
    public MessageService messageService() {
        return new MessageServiceMock();
    }

}