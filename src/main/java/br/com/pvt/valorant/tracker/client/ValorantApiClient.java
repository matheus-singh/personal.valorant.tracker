package br.com.pvt.valorant.tracker.client;

import br.com.pvt.valorant.tracker.core.model.agent.ListOfAgentsResponse;
import br.com.pvt.valorant.tracker.core.model.map.ListOfMapResponse;
import br.com.pvt.valorant.tracker.core.model.tier.ListOfTiersLists;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "valorantApiClient", url = "https://valorant-api.com/v1")
public interface ValorantApiClient {

    // Not riot official api;
    // https://dash.valorant-api.com/endpoints/agents

    @GetMapping("/agents")
    ListOfAgentsResponse getAgents();

    @GetMapping("/maps")
    ListOfMapResponse getMaps();

    @GetMapping("/competitivetiers")
    ListOfTiersLists getTiers();
}
