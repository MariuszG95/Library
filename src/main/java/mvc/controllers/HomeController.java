package mvc.controllers;

import dto.LoggedUserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String get() {
        return "home";
    }
}
