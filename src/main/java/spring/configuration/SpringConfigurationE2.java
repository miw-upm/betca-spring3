package spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "spring.injection.annotation.e2")
//@Import(Configuration.class)
public class SpringConfigurationE2 {
}
