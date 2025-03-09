package br.com.pvt.valorant.tracker.service;

import br.com.pvt.valorant.tracker.core.model.match.Match;
import br.com.pvt.valorant.tracker.core.model.match.dto.MatchDto;

import java.util.List;

public interface MatchService {

    void save(Match match);

    MatchDto getMatchById(Long id);

    List<MatchDto> getMatches();

    void delete(Long id);
}
