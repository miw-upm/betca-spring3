package spring.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.api.uris.AdminUris;

@RestController
@RequestMapping(AdminUris.ADMINS)
public class AdminResource {

    @RequestMapping(value = AdminUris.START, method = RequestMethod.GET)
    public String start() {
        return "OK. Servidor levantado";
    }

    @RequestMapping(value = AdminUris.ECHO + AdminUris.ID, method = RequestMethod.GET)
    public String eco(@RequestHeader(value = "token", required = false) String token, @PathVariable(value = "id") int id,
            @RequestParam(defaultValue = "Non") String param) {
        String response = "@PathVariable:" + id;
        response += "@RequestHeader:" + token;
        response += "@RequestParam:" + param;
        return response;
    }
    
    

}
