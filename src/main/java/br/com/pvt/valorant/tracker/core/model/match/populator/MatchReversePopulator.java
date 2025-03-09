package br.com.pvt.valorant.tracker.core.model.match.populator;

import br.com.pvt.valorant.tracker.controller.request.MatchRegistrationRequest;
import br.com.pvt.valorant.tracker.core.model.match.Match;
import br.com.pvt.valorant.tracker.core.model.match.dto.MatchDto;

import java.time.LocalDate;

public class MatchReversePopulator {
    public static Match populate(MatchDto matchDto) {
        return Match.builder()
                .result(matchDto.result())
                .agent(matchDto.agent())
                .rank(matchDto.rank())
                .rankChange(matchDto.rankChange())
                .kills(matchDto.kills())
                .deaths(matchDto.deaths())
                .assists(matchDto.assists())
                .aces(matchDto.aces())
                .date(matchDto.date())
                .vodLink(matchDto.vodLink())
                .map(matchDto.map())
                .rr(matchDto.rr())
                .build();
    }

    public static Match populate(MatchRegistrationRequest matchRegistrationRequest) {
        return Match.builder()
                .result(matchRegistrationRequest.getResult())
                .agent(matchRegistrationRequest.getAgent())
                .rank(matchRegistrationRequest.getRank())
                .rankChange(matchRegistrationRequest.getRankChange())
                .kills(matchRegistrationRequest.getKills())
                .deaths(matchRegistrationRequest.getDeaths())
                .assists(matchRegistrationRequest.getAssists())
                .aces(matchRegistrationRequest.getAces())
                .date(LocalDate.now())
                .vodLink(matchRegistrationRequest.getVodLink())
                .map(matchRegistrationRequest.getMap())
                .rr(matchRegistrationRequest.getRr())
                .build();
    }
}
