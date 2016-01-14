package spring.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uris.SECURITY)
public class SecurityResource {

    @RequestMapping(value = Uris.USER, method = RequestMethod.GET)
    public String user() {
        return "OK. Acceso permitido";
    }

    @RequestMapping(value = Uris.MANAGER, method = RequestMethod.GET)
    public String manager() {
        return "OK. Acceso permitido";
    }

    @RequestMapping(value = Uris.ADMIN, method = RequestMethod.GET)
    public String admin() {
        return "OK. Acceso permitido";
    }

}
