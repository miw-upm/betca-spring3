package restApi;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restApi.Uris;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.BASICS)
public class BasicResource {

    @RequestMapping(value = Uris.STATE, method = RequestMethod.GET)
    public String start() {
        return "{\"response\":\"OK " + Uris.VERSION + "\"}";
    }

}
