package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import config.PackageNames;

@Configuration
@ComponentScan(basePackages = PackageNames.DAOS)
public class TestsPersistenceConfig {
    
}