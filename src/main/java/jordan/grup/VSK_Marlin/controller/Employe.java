package jordan.grup.VSK_Marlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empl")
public class Employe {


    @GetMapping("/start")
    public String Alluser() {
        return "aplication/start";
    }

}
