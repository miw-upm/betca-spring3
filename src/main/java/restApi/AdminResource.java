package restApi;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restApi.exceptions.MalformedHeaderException;
import restApi.exceptions.UnauthorizedException;
import restApi.exceptions.UserIdNotExistException;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.ADMINS)
public class AdminResource {

    @RequestMapping(value = Uris.START, method = RequestMethod.GET)
    public String start() {
        return "OK. Servidor levantado";
    }

    @RequestMapping(value = Uris.ECHO + Uris.ID, method = RequestMethod.GET)
    public String eco(@RequestHeader(value = "token", required = false) String token, @PathVariable(value = "id") int id,
            @RequestParam(defaultValue = "Non") String param) {
        String response = "@PathVariable:" + id;
        response += "@RequestHeader:" + token;
        response += "@RequestParam:" + param;
        return response;
    }

    @RequestMapping(value = Uris.BODY, method = RequestMethod.POST)
    public Wrapper body(@RequestBody Wrapper wrapper) {
        return wrapper;
    }

    @RequestMapping(value = Uris.BODY + Uris.STRING_LIST, method = RequestMethod.GET)
    public List<String> bodyStringList() {
        return Arrays.asList("uno", "dos", "tres");
    }

    @RequestMapping(value = Uris.BODY + Uris.WRAPPER_LIST, method = RequestMethod.GET)
    public List<Wrapper> bodyWrapperList() {
        Wrapper wrapper1 = new Wrapper(666, "daemon", Gender.FEMALE, new GregorianCalendar(1979, 07, 22));
        Wrapper wrapper2 = new Wrapper(999, "last", Gender.MALE, new GregorianCalendar(1979, 07, 22));
        Wrapper wrapper3 = new Wrapper(000, "first", Gender.FEMALE, new GregorianCalendar(1979, 07, 22));
        return Arrays.asList(wrapper1, wrapper2, wrapper3);
    }

    @RequestMapping(value = Uris.ERROR + Uris.ID, method = RequestMethod.GET)
    public Wrapper error(@RequestHeader(value = "token") String token, @PathVariable(value = "id") int id) throws UserIdNotExistException,
            UnauthorizedException, MalformedHeaderException {
        if (id == 0) {
            throw new UserIdNotExistException("id:" + id);
        }
        if (token.equals("kk")) {
            throw new MalformedHeaderException("token:" + token);
        }
        if (token.equals("Basic kk")) {
            throw new UnauthorizedException("token:" + token);
        }
        return new Wrapper(666, "daemon", Gender.FEMALE, new GregorianCalendar(1979, 07, 22));
    }

}
