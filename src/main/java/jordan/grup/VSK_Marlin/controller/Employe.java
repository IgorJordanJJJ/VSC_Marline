package jordan.grup.VSK_Marlin.controller;

import jordan.grup.VSK_Marlin.models.Application;
import jordan.grup.VSK_Marlin.models.CICDDeployment;
import jordan.grup.VSK_Marlin.models.GitRepositories;
import jordan.grup.VSK_Marlin.models.Person;
import jordan.grup.VSK_Marlin.services.ApplicationService;
import jordan.grup.VSK_Marlin.services.CICDDeploymentService;
import jordan.grup.VSK_Marlin.services.GitRepositoriesSevice;
import jordan.grup.VSK_Marlin.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/empl")
public class Employe {

    private final ApplicationService applicationService;
    private final CICDDeploymentService cicdDeploymentService;
    private final GitRepositoriesSevice gitRepositoriesSevice;

    private final PersonDetailsService personDetailsService;

    @Autowired
    public Employe(ApplicationService applicationService, CICDDeploymentService cicdDeploymentService, GitRepositoriesSevice gitRepositoriesSevice, PersonDetailsService personDetailsService) {
        this.applicationService = applicationService;
        this.cicdDeploymentService = cicdDeploymentService;
        this.gitRepositoriesSevice = gitRepositoriesSevice;
        this.personDetailsService = personDetailsService;
    }


    @GetMapping("/start")
    public String Alluser() {
        return "aplication/start";
    }

    @GetMapping("/app/all")
    public String Allapp(Model model){
        model.addAttribute("application", applicationService.findAll());
        model.addAttribute("gitrepositories", gitRepositoriesSevice.findAll());
        return "aplication/allapp";
    }

    @GetMapping("/app/new")
    public String newApp(@ModelAttribute("app") @Valid Application application){
        return "aplication/newapp";
    }



    @GetMapping("/app/creator")
    public String newCreator(@ModelAttribute("app") @Valid Application application, @ModelAttribute("gitrepositories") @Valid GitRepositories gitRepositories, @ModelAttribute("cicddeploy") @Valid CICDDeployment cicdDeployment){
        return "aplication/creator";
    }



}
