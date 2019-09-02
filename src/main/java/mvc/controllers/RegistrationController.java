package mvc.controllers;

import core.services.UserService;
import dto.RegistrationFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Iterator;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Autowired
    private void RegistrationController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping
    public String prepareForm(Model model) {
        model.addAttribute("registrationFormDTO", new RegistrationFormDTO());

        return "registration";
    }

    @PostMapping
    public String register(@Valid RegistrationFormDTO registrationFormDTO, BindingResult bindingResult) {
        HashMap<String, String> errors = registrationFormDTO.getErrors();
        if (bindingResult.hasErrors()) {
            BeanPropertyBindingResult beanPropertyBindingResult = (BeanPropertyBindingResult) bindingResult.getModel()
                    .get("org.springframework.validation.BindingResult.registrationFormDTO");
            Iterator<FieldError> iterator = beanPropertyBindingResult.getFieldErrors().iterator();
            while (iterator.hasNext()) {
                FieldError fieldError = iterator.next();
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return "registration";
        }
        if (!registrationFormDTO.getPassword().equals(registrationFormDTO.getRepeatedPassword())) {
            errors.put("repeatedPassword", "Hasła nie są identyczne!");
            return "registration";
        }
        if (userService.isLoginTaken(registrationFormDTO.getLogin())) {
            errors.put("login", "Login jest już zajęty!");
            return "registration";
        }

        registrationFormDTO.setPassword(passwordEncoder.encode(registrationFormDTO.getPassword()));
        userService.addNewUser(registrationFormDTO);

        return "home";
    }
}
