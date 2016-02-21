package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.MailConfig;
import config.PackageNames;


@Configuration
@Import({MailConfig.class})
@ComponentScan(PackageNames.REST_API)
public class TestsMailConfig {

}
