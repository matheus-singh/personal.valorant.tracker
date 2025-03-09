package br.com.pvt.valorant.tracker.controller;

import br.com.pvt.valorant.tracker.core.model.match.dto.MatchDto;
import br.com.pvt.valorant.tracker.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private MatchService matchService;

    @Autowired
    public HomeController(MatchService matchService){
        this.matchService = matchService;
    }

    // Lista as partidas cadastradas
    @GetMapping("/")
    public ModelAndView alsoHome(){
        List<MatchDto> matches = matchService.getMatches();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("matches", matches);
        return modelAndView;
    }

    // Lista as partidas cadastradas
    @GetMapping("/home")
    public ModelAndView home(){
        List<MatchDto> matches = matchService.getMatches();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("matches", matches);
        return modelAndView;
    }
}
