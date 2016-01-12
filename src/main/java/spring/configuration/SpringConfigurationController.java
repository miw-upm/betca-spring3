package spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"spring.persistence.controller", "spring.persistence.daos"})
@Import(PersistenceConfiguration.class)
public class SpringConfigurationController {
}
