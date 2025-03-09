package br.com.pvt.valorant.tracker.core.repository;

import br.com.pvt.valorant.tracker.core.model.match.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
