package config.webRestApi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import config.MailConfig;
import config.PackageNames;
import config.SecurityConfig;
import restApi.TimeBasedAccessInterceptor;
import restApi.Uris;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {PackageNames.REST_API, PackageNames.WEB})
@Import(value = {MailConfig.class, SecurityConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    // Se configuran los interceptores
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeBasedAccessInterceptor()).addPathPatterns(Uris.SERVLET_MAP + Uris.ADMINS + "/**")
                .excludePathPatterns("/foo/**");
    }

    // CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").maxAge(3600);
    }

}
