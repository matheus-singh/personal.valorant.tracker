package br.com.pvt.valorant.tracker.controller;

import br.com.pvt.valorant.tracker.controller.request.MatchRegistrationRequest;
import br.com.pvt.valorant.tracker.facade.MatchFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/match")
public class MatchController {

    private final MatchFacade matchFacade;

    @Autowired
    public MatchController (MatchFacade matchFacade) {
        this.matchFacade = matchFacade;
    }

    // Exibe o formulario de cadastro
    @GetMapping("/register")
    public ModelAndView registerMatch(){
        return matchFacade.registerNewMatch();
    }

    // Recebe os dados do formulário e processa o registro
    @PostMapping("/register")
    public ModelAndView registerMatch(@ModelAttribute("matchRegistrationRequest") MatchRegistrationRequest matchRegistrationRequest) {
        return matchFacade.registerNewMatch(matchRegistrationRequest);
    }

    @PostMapping("/delete/{id}")
    public String deleteMatch(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        return matchFacade.deleteMatch(id, redirectAttributes);
    }
}
