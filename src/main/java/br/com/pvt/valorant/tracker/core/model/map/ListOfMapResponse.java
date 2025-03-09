package br.com.pvt.valorant.tracker.core.model.map;

import br.com.pvt.valorant.tracker.core.model.agent.AgentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListOfMapResponse {
    private int status;
    private List<MapResponse> data;
}
