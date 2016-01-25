package injection.annotation.e2;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@PropertySource("classpath:application.properties")
// @PropertySource("file:///C:/Temp/application.properties")
// @PropertySource("http://myserver/application.properties")
public class ExtendedMessageService {

    @Autowired
    private Environment environment;

    private String prefix;

    private String suffix;

    private Map<String, String> messageMap;

    public ExtendedMessageService() {
        messageMap = new HashMap<>();
        prefix = "";
        //OJO la inyección no está realizada
    }

    @PostConstruct
    public void postConstruct() {
        suffix = environment.getProperty("e2.suffix");
    }

    public void add(String key, String message) {
        messageMap.put(prefix + key + suffix, message);
    }

    public String message(String key) {
        return messageMap.get(prefix + key + suffix);
    }

    public String key(String message) {
        for (String key : messageMap.keySet()) {
            if (messageMap.get(key).equals(message)) {
                return key;
            }
        }
        return null;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
