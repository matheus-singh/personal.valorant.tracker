package br.com.pvt.valorant.tracker.service.impl;

import br.com.pvt.valorant.tracker.client.ValorantApiClient;
import br.com.pvt.valorant.tracker.service.ValorantApiClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DefaultValorantApiClientService implements ValorantApiClientService {

    private final ValorantApiClient valorantApiClient;

    // Constructor injection
    @Autowired
    public DefaultValorantApiClientService(ValorantApiClient valorantApiClient) {
        this.valorantApiClient = valorantApiClient;
    }

    @Override
    public List<String> getAgents() {
        List<String> agents = new ArrayList<>();
        valorantApiClient.getAgents().getData().forEach(agent -> agents.add(agent.getDisplayName()));
        return agents;
    }

    @Override
    public List<String> getMaps() {
        List<String> maps = new ArrayList<>();
        valorantApiClient.getMaps().getData().forEach(map -> maps.add(map.getDisplayName()));
        Iterator<String> iterator = maps.iterator();
        while (iterator.hasNext()) {
            String map = iterator.next();
            switch (map) {
                case "District", "Piazza", "Kasbah", "Drift", "Glitch", "Basic Training", "The Range":
                    iterator.remove();  // Remover o item da lista
                    break;
                default:
                    break;
            }
        }
        return maps;
    }


    @Override
    public List<String> getRanks() {
        List<String> ranks = new ArrayList<>();
        valorantApiClient.getTiers()
                .getData()
                .getFirst()
                .getTiersResponseList()
                .forEach(competitiveEpisodesResponse -> ranks.add(competitiveEpisodesResponse.getTierName()));
        Iterator<String> iterator = ranks.iterator();
        while (iterator.hasNext()) {
            String rank = iterator.next();
            switch (rank) {
                case "UNRANKED", "Unused1", "Unused2":
                    iterator.remove();  // Remover o item da lista
                    break;
                default:
                    break;
            }
        }
        return ranks;
    }
}
