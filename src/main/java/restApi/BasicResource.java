package restApi;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restApi.Uris;

@RestController
@RequestMapping(Uris.VERSION + Uris.BASICS)
public class BasicResource {

    @RequestMapping(value = Uris.VERSION, method = RequestMethod.GET)
    public String state() {
        return "{\"version\":\"" + Uris.VERSION + "\"}";
    }

}
