package config.enterprise;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"persistence.controller", "persistence.daos"})
@Import(PersistenceConfig.class)
public class ControllerConfig {
}
