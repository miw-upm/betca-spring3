package spring.configurationMain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"spring.persistence.controller", "spring.persistence.daos"})
@Import(PersistenceConfig.class)
public class ControllerConfig {
}
