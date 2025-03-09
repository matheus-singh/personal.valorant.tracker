package br.com.pvt.valorant.tracker.service.impl;

import br.com.pvt.valorant.tracker.core.model.match.Match;
import br.com.pvt.valorant.tracker.core.model.match.dto.MatchDto;
import br.com.pvt.valorant.tracker.core.repository.MatchRepository;
import br.com.pvt.valorant.tracker.exceptions.MatchNotFoundException;
import br.com.pvt.valorant.tracker.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.pvt.valorant.tracker.core.model.match.populator.MatchPopulator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultMatchService implements MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public DefaultMatchService (MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }

    @Override
    public void save(Match match) {
        matchRepository.save(match);
    }

    @Override
    public MatchDto getMatchById(Long id) {
        Match match = matchRepository.findById(id).orElse(null);
        if (match != null) {
            return MatchPopulator.populate(match);
        }
        throw new MatchNotFoundException("Match with ID " + id + " not found.");
    }


    @Override
    public List<MatchDto> getMatches() {
        return matchRepository.findAll().stream().map(MatchPopulator::populate).toList();
    }

    @Override
    public void delete(Long id) {
        Optional<Match> match = matchRepository.findById(id);
        match.ifPresent(matchRepository::delete);
    }
}
