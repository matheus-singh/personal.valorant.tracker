package br.com.pvt.valorant.tracker.core.model.statistics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatisticsDto {
    private Long totalMatches;
    private Long wins;
    private Long losses;
    private Long draws;
    private Double winRate;
    private Double avgKills;
    private Double avgDeaths;
    private Double avgAssists;
    private String currentRank;
    private String favoriteAgent;
    private Long winsWithFavoriteAgent;
    private Long lossesWithFavoriteAgent;
    private Double winRateWithFavoriteAgent;
    private Map<String, Long> agentFrequency;
}
