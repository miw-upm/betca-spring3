package spring.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.api.uris.AdminUris;

@RestController
@RequestMapping(AdminUris.ADMINS)
public class AdminResource {

    @RequestMapping(value = AdminUris.START, method = RequestMethod.GET)
    public String start() {
        return "OK. Servidor levantado";
    }

}
