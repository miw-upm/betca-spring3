package spring.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.apiConfig.MailConfig;

@Configuration
@Import({MailConfig.class})
@ComponentScan({"spring.api"})
public class TestMailConfiguration {

}
