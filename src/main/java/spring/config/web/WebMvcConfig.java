package spring.config.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import spring.config.enterprise.MailConfig;
import spring.restApi.RequestProcessingTimeInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"spring.restApi", "spring.mvc"})
@Import(value = {MailConfig.class})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    // Se configuran los interceptores
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestProcessingTimeInterceptor()).addPathPatterns("/admins/**").excludePathPatterns("/foo/**");
    }

    // CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").maxAge(3600);
    }

}
