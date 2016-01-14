package spring.configurationApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import spring.api.Uris;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().//
                withUser("user").password("123456").roles("USER").and().//
                withUser("manager").password("123456").roles("MANAGER").and().//
                withUser("admin").password("123456").roles("ADMIN","MANAGER","USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()//
                .antMatchers(HttpMethod.GET, Uris.SERVLET_MAP + Uris.SECURITY + Uris.ADMIN).hasRole("ADMIN")//
                // antMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN").//
                // antMatchers(HttpMethod.PATCH, "/employees/**").hasRole("ADMIN").//
                .anyRequest().permitAll().and()//
                .httpBasic().and()//
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
