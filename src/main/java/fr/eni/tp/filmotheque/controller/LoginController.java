package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.contexte.ContexteService;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SessionAttributes({"membresSession"})
@Controller
public class LoginController {

    private ContexteService contexteService;

    public LoginController(ContexteService contexteService){
        this.contexteService = contexteService;
    }

    @GetMapping(path="/login")
    private String loginPage(){
        return "login";
    }

    @GetMapping(path="/login?logout")
    private String logout(){
        return "redirect:/";
    }

    @RequestMapping(path="/session",method={RequestMethod.GET,RequestMethod.POST})
    public String connexion(@RequestParam(name="email", defaultValue = "jtrillard@campus-eni.fr")
            @ModelAttribute("membresSession") Membre membre, String email ,Model model){
            membre = contexteService.charger(email);

        return "view-contexte";
    }

    @ModelAttribute("membresSession")
    public Membre AddMembre(){
        Membre membre = new Membre();
        return membre;
    }




}
