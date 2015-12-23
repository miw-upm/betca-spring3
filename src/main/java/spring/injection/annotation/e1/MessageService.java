package spring.injection.annotation.e1;

import org.springframework.stereotype.Service;

@Service //@Service("messageService")
//@Scope("singleton")
public class MessageService {
    private int i = 0;

    public String message() {
        return "Mensaje... " + i++;
    }
}
