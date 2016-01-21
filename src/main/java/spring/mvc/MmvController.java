package spring.mvc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@Scope("session")
@SessionAttributes("name")
public class MmvController {

    private static final List<String> THEMES = Arrays.asList("jsp", "bootstrap", "thymeleaf");

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private UserService userService;

    private String theme = THEMES.get(0);

    public MmvController() {
    }

    // Se ejecuta siempre y antes. Añade un atributo al Model
    @ModelAttribute("now")
    public String addDate() {
        return new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss").format(new Date());
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("themes", THEMES);
        return theme + "/home";
    }

    @RequestMapping("/theme")
    public String theme(@RequestParam String theme, Model model) {
        this.theme = theme;
        model.addAttribute("themes", THEMES);
        return theme + "/home";
    }

    @RequestMapping(value = "/greeting")
    public String greeting(@CookieValue("JSESSIONID") Cookie cookie, HttpServletRequest request, Model model) {
        model.addAttribute("stringList", Arrays.asList("uno", "dos", "tres"));
        model.addAttribute("cookie", cookie.getName());
        model.addAttribute("ip", request.getRemoteAddr());
        return theme + "/greeting";
    }

    @RequestMapping("/user-list")
    public String listUsers(Model model) {
        model.addAttribute("userList", userService.findAll());
        return theme + "/userList";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(LoginUser loginUser, BindingResult bindingResult, Model model) {
        User user = userService.findOne(loginUser.getId());
        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            model.addAttribute("name", user.getName());
        } else {
            bindingResult.rejectValue("id", "error.loginUser", "Usuario o clave incorrecto");
        }
        return theme + "/greeting";
    }

    @RequestMapping(value = {"/delete-user/{id}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/user-list";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("user", new User(userService.generateId(), "", 18, ""));
        model.addAttribute("languages", userService.languages());
        return theme + "/createUser";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public String createUserSubmit(@Valid User user, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            if (userService.save(user)) {
                model.addAttribute("name", user.getName());
                return theme + "/registrationSuccess";
            } else {
                bindingResult.rejectValue("id", "error.user", "Usuario ya existente");
            }
        }
        model.addAttribute("languages", userService.languages());
        return theme + "/createUser";
    }

}
