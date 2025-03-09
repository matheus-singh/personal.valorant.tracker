package br.com.pvt.valorant.tracker.service;

import br.com.pvt.valorant.tracker.core.model.statistics.PlayerStatisticsDto;

public interface PlayerStatisticsService {
    PlayerStatisticsDto getOverallStats();
}
