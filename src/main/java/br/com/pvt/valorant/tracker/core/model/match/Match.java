package br.com.pvt.valorant.tracker.core.model.match;

import br.com.pvt.valorant.tracker.core.model.enums.MATCH_RESULT;
import br.com.pvt.valorant.tracker.core.model.enums.RANK_CHANGE;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MATCH_RESULT result;

    private String agent;

    private String rank;

    @Enumerated(EnumType.STRING)
    private RANK_CHANGE rankChange;

    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Integer aces;

    @Column(nullable = false)
    private LocalDate date = LocalDate.now(); // Default to current date

    @Column(length = 500)
    private String vodLink;

    private String map;

    private Integer rr;
}
