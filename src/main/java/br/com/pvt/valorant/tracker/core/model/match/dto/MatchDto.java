package br.com.pvt.valorant.tracker.core.model.match.dto;

import br.com.pvt.valorant.tracker.core.model.enums.MATCH_RESULT;
import br.com.pvt.valorant.tracker.core.model.enums.RANK_CHANGE;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record MatchDto(
        Long id,
        MATCH_RESULT result,
        String agent,
        String rank,
        RANK_CHANGE rankChange,
        Integer kills,
        Integer deaths,
        Integer assists,
        Integer aces,
        LocalDate date,
        String vodLink,
        String map,
        Integer rr
) {
}
