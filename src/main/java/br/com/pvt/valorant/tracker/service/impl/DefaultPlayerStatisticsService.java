package br.com.pvt.valorant.tracker.service.impl;

import br.com.pvt.valorant.tracker.core.model.enums.MATCH_RESULT;
import br.com.pvt.valorant.tracker.core.model.enums.RANK_CHANGE;
import br.com.pvt.valorant.tracker.core.model.match.Match;
import br.com.pvt.valorant.tracker.core.model.statistics.PlayerStatisticsDto;
import br.com.pvt.valorant.tracker.core.repository.MatchRepository;
import br.com.pvt.valorant.tracker.service.PlayerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DefaultPlayerStatisticsService implements PlayerStatisticsService {
    private final MatchRepository matchRepository;

    @Autowired
    public DefaultPlayerStatisticsService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public PlayerStatisticsDto getOverallStats() {
        List<Match> matches = matchRepository.findAll();

        PlayerStatisticsDto stats = PlayerStatisticsDto.builder()
                .totalMatches((long) matches.size())
                .wins(matches.stream().filter(m -> m.getResult().equals(MATCH_RESULT.WIN)).count())
                .losses(matches.stream().filter(m -> m.getResult().equals(MATCH_RESULT.LOSS)).count())
                .draws(matches.stream().filter(m -> m.getResult().equals(MATCH_RESULT.DRAW)).count())
                .build();

        stats.setWinRate(matches.isEmpty() ? 0 : ((double) stats.getWins() / matches.size()) * 100);
        stats.setAvgKills(matches.stream().mapToInt(Match::getKills).average().orElse(0));
        stats.setAvgDeaths(matches.stream().mapToInt(Match::getDeaths).average().orElse(0));
        stats.setAvgAssists(matches.stream().mapToInt(Match::getAssists).average().orElse(0));

        if (!matches.isEmpty()) {
            stats.setCurrentRank(matches.getLast().getRank());
        } else {
            stats.setCurrentRank("Unranked");
        }

        Map<String, Long> agentFrequency = matches.stream()
                .collect(Collectors.groupingBy(Match::getAgent, Collectors.counting()));

        stats.setAgentFrequency(agentFrequency);

        stats.setFavoriteAgent(agentFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Unknown"));

        List<Match> matchesWithFavoritAgent = matches.stream().filter(match -> match.getAgent().equals(stats.getFavoriteAgent())).toList();

        stats.setWinsWithFavoriteAgent(matchesWithFavoritAgent.stream().filter(m -> m.getResult().equals(MATCH_RESULT.WIN)).count());
        stats.setLossesWithFavoriteAgent(matchesWithFavoritAgent.stream().filter(m -> m.getResult().equals(MATCH_RESULT.LOSS)).count());
        stats.setWinRateWithFavoriteAgent(matchesWithFavoritAgent.isEmpty() ? 0 : ((double) stats.getWinsWithFavoriteAgent() / matchesWithFavoritAgent.size()) * 100 );

        return stats;
    }
}
