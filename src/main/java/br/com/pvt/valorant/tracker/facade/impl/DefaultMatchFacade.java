package br.com.pvt.valorant.tracker.facade.impl;

import br.com.pvt.valorant.tracker.controller.request.MatchRegistrationRequest;
import br.com.pvt.valorant.tracker.core.model.enums.MATCH_RESULT;
import br.com.pvt.valorant.tracker.core.model.enums.RANK_CHANGE;
import br.com.pvt.valorant.tracker.core.model.match.dto.MatchDto;
import br.com.pvt.valorant.tracker.core.model.match.populator.MatchReversePopulator;
import br.com.pvt.valorant.tracker.facade.MatchFacade;
import br.com.pvt.valorant.tracker.service.MatchService;
import br.com.pvt.valorant.tracker.service.ValorantApiClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class DefaultMatchFacade implements MatchFacade {

    private final MatchService matchService;
    private final ValorantApiClientService valorantApiClientService;

    public DefaultMatchFacade (MatchService matchService, ValorantApiClientService valorantApiClientService) {
        this.matchService = matchService;
        this.valorantApiClientService = valorantApiClientService;
    }

    @Override
    public ModelAndView registerNewMatch() {
        MatchRegistrationRequest matchRegistrationRequest = new MatchRegistrationRequest();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("matchRegistration");
        modelAndView.addObject("matchRegistrationRequest", matchRegistrationRequest);
        modelAndView.addObject("MATCH_RESULTS", MATCH_RESULT.values());
        modelAndView.addObject("RANK_CHANGE", RANK_CHANGE.values());
        modelAndView.addObject("agentsList", valorantApiClientService.getAgents());
        modelAndView.addObject("ranksList", valorantApiClientService.getRanks());
        modelAndView.addObject("mapsList", valorantApiClientService.getMaps());
        return modelAndView;
    }

    @Override
    public ModelAndView registerNewMatch(MatchRegistrationRequest matchRegistrationRequest) {
        matchService.save(MatchReversePopulator.populate(matchRegistrationRequest));
        List<MatchDto> matches = matchService.getMatches();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("matches", matches);
        return modelAndView;
    }

    @Override
    public String deleteMatch(Long id, RedirectAttributes redirectAttributes) {
        try {
            matchService.delete(id);
            redirectAttributes.addFlashAttribute("successMessage", "Match deleted successfully!");
            return "redirect:/home";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete match.");
            return "redirect:/home";
        }
    }
}
