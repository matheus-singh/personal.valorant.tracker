package br.com.pvt.valorant.tracker.controller.request;

import br.com.pvt.valorant.tracker.core.model.enums.MATCH_RESULT;
import br.com.pvt.valorant.tracker.core.model.enums.RANK_CHANGE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchRegistrationRequest {
    private MATCH_RESULT result;
    private String agent;
    private String rank;
    private RANK_CHANGE rankChange;
    private Integer rr;
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Integer aces;
    private String vodLink;
    private String map;
}
