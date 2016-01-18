package spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.config.enterprise.MailConfig;


@Configuration
@Import({MailConfig.class})
@ComponentScan({"spring.restApi"})
public class TestsMailConfiguration {

}
