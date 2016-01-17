package spring.restApiConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import spring.restApi.RequestProcessingTimeInterceptor;
import spring.restApi.Uris;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"spring.restApi"})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    // Se configuran los interceptores
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestProcessingTimeInterceptor()).addPathPatterns("/admins/**").excludePathPatterns("/foo/**");
    }
    
    //CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(Uris.SERVLET_MAP + "/**")
            .allowedOrigins("*").maxAge(3600)
            .allowedMethods("POST","PUT","PATH","GET","DELETE","OPTIONS")
            .allowedHeaders("Authorization");
    }


}
