package spring.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.configurationApi.SpringMailConfiguration;

@Configuration
@Import({SpringMailConfiguration.class})
@ComponentScan({"spring.api"})
public class TestMailConfiguration {

}
