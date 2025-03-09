package br.com.pvt.valorant.tracker.core.model.tier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListOfTiersLists {
    private int status;
    private List<TiersLists> data;
}
