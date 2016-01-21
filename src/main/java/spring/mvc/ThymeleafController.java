package spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    public ThymeleafController() {
    }

    @RequestMapping("th/home")
    public String home(Model model) {
        model.addAttribute("title", "Hello world! from Thymeleaf");
        return "thymeleaf/home";
    }

}
