package jordan.grup.VSK_Marlin.controller;


import jordan.grup.VSK_Marlin.models.Person;
import jordan.grup.VSK_Marlin.services.RegistratinService;
import jordan.grup.VSK_Marlin.utils.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistratinService registratinService;
    private final PersonValidator personValidator;

    @Autowired
    public AuthController(RegistratinService registratinService, PersonValidator personValidator) {
        this.registratinService = registratinService;
        this.personValidator = personValidator;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);

        if(bindingResult.hasErrors())
            return "/auth/registration";
        registratinService.register(person);
        return "redirect:/auth/login";

    }
}
