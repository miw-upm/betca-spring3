package spring.mvc;

import java.util.Arrays;
import java.util.Date;

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

    private String theme = "";

    public MmvController() {
    }

    @Autowired
    private UserService userService;

    // Se ejecuta siempre
    @ModelAttribute("now")
    public String addDate() {
        return new Date().toString();
    }

    @RequestMapping("/home")
    public String home(Model model) {
        if (model.asMap().get("name") == null) {
            model.addAttribute("name", "World");
        }
        return "home" + theme;
    }

    @RequestMapping("/theme")
    public String theme(@RequestParam String theme, Model model) {
        this.theme = theme;
        return "home" + theme;
    }

    @RequestMapping(value = "/greeting")
    public String greeting(@CookieValue("JSESSIONID") Cookie cookie, HttpServletRequest request, Model model) {
        model.addAttribute("stringList", Arrays.asList("uno", "dos", "tres"));
        model.addAttribute("cookie", cookie.getName());
        model.addAttribute("ip", request.getRemoteAddr());
        return "greeting" + theme;
    }

    @RequestMapping("/user-list")
    public String listUsers(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "userList" + theme;
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
        return "createUser" + theme;
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public String createUserSubmit(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("languages", userService.languages());
            return "createUser" + theme;
        } else {
            if (!userService.save(user)) {
                bindingResult.rejectValue("id", "error.user", "Usuario ya existente");
                model.addAttribute("languages", userService.languages());
                return "createUser" + theme;
            } else {
                model.addAttribute("name", user.getName());
                return "registrationSuccess" + theme;
            }
        }
    }

}
