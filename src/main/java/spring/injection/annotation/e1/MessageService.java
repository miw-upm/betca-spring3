package spring.injection.annotation.e1;

import org.springframework.stereotype.Service;

// @Service("messageService") por defecto
// @Service(ConfigurableBeanFactory.SCOPE_SINGLETON) por defecto
// @Service(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Service()
public class MessageService {
    private int i = 0;

    public String message() {
        return "Mensaje... " + i++;
    }
}
