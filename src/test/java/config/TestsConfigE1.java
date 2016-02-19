package config;

import injection.e1e2e4.MessageService;
import injection.e1e2e4.MessageServiceMock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "injection.e1e2e4")
public class TestsConfigE1 {
    
    @Bean
    public MessageService messageService() {
        return new MessageServiceMock();
    }

}