package config.start;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"injection.annotation.e1"})
public class AnnotationE1Config {
}
