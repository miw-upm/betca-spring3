package spring.injection.annotation.e2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@PropertySource("classpath:application.properties")
//@PropertySource("file:///C:/Temp/application.properties")
//@PropertySource("http://myserver/application.properties")

    public class MessageService {

    @Autowired
    private Environment environment;

    private String prefix;

    private int i;

    public MessageService() {
        prefix = "";
        i = 0;
    }

    public String message() {
        return prefix + environment.getProperty("e2.message") + i++;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
