package config.enterprise;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {PackageNames.CONTROLLERS, PackageNames.DAOS})
@Import(PersistenceConfig.class)
public class ControllerConfig {
}
