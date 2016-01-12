package spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "spring.persistence.daos")
public class SpringTestPersistenceConfiguration {
    
}