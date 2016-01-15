package spring.restApi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.restApiConfig.MailConfig;

@Configuration
@Import({MailConfig.class})
@ComponentScan({"spring.restApi"})
public class TestMailConfiguration {

}
