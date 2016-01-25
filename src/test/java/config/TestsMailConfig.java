package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.enterprise.MailConfig;


@Configuration
@Import({MailConfig.class})
@ComponentScan({"restApi"})
public class TestsMailConfig {

}
