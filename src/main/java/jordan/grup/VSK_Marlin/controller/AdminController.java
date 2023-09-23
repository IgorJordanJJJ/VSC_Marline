package jordan.grup.VSK_Marlin.controller;


import jordan.grup.VSK_Marlin.models.Person;
import jordan.grup.VSK_Marlin.services.PersonDetailsService;
import jordan.grup.VSK_Marlin.services.RegistratinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PersonDetailsService personDetailsService;

    private final RegistratinService registratinService;
    @Autowired
    public AdminController(PersonDetailsService personDetailsService, RegistratinService registratinService) {
        this.personDetailsService = personDetailsService;
        this.registratinService = registratinService;
    }


    @GetMapping()
    public String Comand() {
        return "admin/controlpanel";
    }

    @GetMapping("/alluser")
    public String Alluser(Model model) {
        model.addAttribute("users", personDetailsService.findAll());
        return "admin/alluser";
    }
    @GetMapping("/user/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", personDetailsService.findOne(id));
        return "admin/show";
    }

    @GetMapping("/user/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", personDetailsService.findOne(id));
        return "admin/edit";
    }

    @PostMapping("/user/{id}")
    public String update(@ModelAttribute("user") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "admin/edit";
        }
        registratinService.update(person,id);
        return "redirect:/admin/alluser";
    }


    @PostMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDetailsService.delete(id);
        return "redirect:/admin/alluser";
    }

}
