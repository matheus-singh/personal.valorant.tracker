package br.com.pvt.valorant.tracker.facade;

import br.com.pvt.valorant.tracker.controller.request.MatchRegistrationRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface MatchFacade {

    ModelAndView registerNewMatch();

    ModelAndView registerNewMatch(MatchRegistrationRequest matchRegistrationRequest);

    String deleteMatch(Long id, RedirectAttributes redirectAttributes);
}
