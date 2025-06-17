package fr.eni.tp.filmotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class loginController {

    @RequestMapping(path="/login",  method = {RequestMethod.GET, RequestMethod.POST})
    private String login(){
        return "login";
    }

}
