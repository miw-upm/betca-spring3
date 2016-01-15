package spring.apiConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import spring.api.RequestProcessingTimeInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"spring.api"})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    // Se configuran los interceptores
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestProcessingTimeInterceptor()).addPathPatterns("/admins/**").excludePathPatterns("/foo/**");
    }

}
