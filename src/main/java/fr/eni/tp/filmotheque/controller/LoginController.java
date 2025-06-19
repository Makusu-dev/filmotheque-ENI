package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.contexte.ContexteService;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes({"membreSession"})
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


    @GetMapping(path="/contexte")
    private String connexion(){
        return "view-contexte";
    }

    @RequestMapping(path="/session",method={RequestMethod.GET,RequestMethod.POST})
    public String connexion(
            @ModelAttribute("membreSession") Membre membreSession,
            @RequestParam(name="email", defaultValue = "jtrillard@campus-eni.fr", required = false) String email)
            {
        System.out.println("mail passé en paramètre"+email);

        Membre membreCharge =  contexteService.charger(email);

        System.out.println("Utilisateur chargé avec le mail"+membreCharge.getPseudo());

                if (membreCharge != null) {
                    membreSession.setPseudo(membreCharge.getPseudo());
                    membreSession.setId(membreCharge.getId());
                }
                else
                {
                    membreSession.setPseudo(null);
                    membreSession.setId(0);
                }

                System.out.println("Le membre en session est désormais"+membreSession.getPseudo());

        return "redirect:/";
    }

    @RequestMapping("/deconnexion")
    public String finSession(SessionStatus status) {

        status.setComplete();
        return "redirect:/contexte"; // Redirection
    }


    @ModelAttribute("membreSession")
    public Membre AddMembre(){
        System.out.println("Add Attribut Membre to Session");
        return new Membre();
    }




}
