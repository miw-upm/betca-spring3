package spring.configurationApi;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"spring.api"})
public class SpringConfigurationApi extends WebMvcConfigurerAdapter{

    private static final String PATTERN_DATE = "yyyy-MM-dd";

    // private static final String PATTERN_DATE2 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customConverter());
    }

    @Bean
    public MappingJackson2HttpMessageConverter customConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat(PATTERN_DATE));
        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        converter.setObjectMapper(objectMapper);
        return converter;
    }

}
