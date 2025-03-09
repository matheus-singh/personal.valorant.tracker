package br.com.pvt.valorant.tracker.core.model.match.populator;

import br.com.pvt.valorant.tracker.controller.request.MatchRegistrationRequest;
import br.com.pvt.valorant.tracker.core.model.match.Match;
import br.com.pvt.valorant.tracker.core.model.match.dto.MatchDto;


public class MatchPopulator {
    public static MatchDto populate(Match match) {
        return MatchDto.builder()
                .id(match.getId())
                .result(match.getResult())
                .agent(match.getAgent())
                .rank(match.getRank())
                .rankChange(match.getRankChange())
                .kills(match.getKills())
                .deaths(match.getDeaths())
                .assists(match.getAssists())
                .aces(match.getAces())
                .date(match.getDate())
                .vodLink(match.getVodLink())
                .map(match.getMap())
                .rr(match.getRr())
                .build();
    }
}
