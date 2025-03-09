package br.com.pvt.valorant.tracker.config;

import br.com.pvt.valorant.tracker.core.model.enums.MATCH_RESULT;
import br.com.pvt.valorant.tracker.core.model.enums.RANK_CHANGE;
import br.com.pvt.valorant.tracker.core.model.match.Match;
import br.com.pvt.valorant.tracker.core.repository.MatchRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(MatchRepository matchRepository) {
        return args -> {
            // Check if there are existing matches in the database
            if (matchRepository.count() == 0) {
                // Initialize with 3 sample Valorant matches
                matchRepository.save(new Match(
                        null,
                        MATCH_RESULT.WIN,
                        "Phoenix",
                        "Gold",
                        RANK_CHANGE.UP,
                        25,
                        10,
                        5,
                        1,
                        LocalDate.now(),
                        "https://www.youtube.com/embed/a-ZSlOYSPLQ?si=dZQXQC5sOybI14we",
                        "Bind",
                        +21
                ));
                matchRepository.save(new Match(
                        null,
                        MATCH_RESULT.LOSS,
                        "Jett",
                        "Platinum",
                        RANK_CHANGE.DOWN,
                        10,
                        20,
                        8,
                        0,
                        LocalDate.now(),
                        "https://www.youtube.com/embed/s_NjGillgE8?si=YLu7I2IXw6xpuL3R",
                        "Ascent",
                        -23
                ));
                matchRepository.save(new Match(
                        null,
                        MATCH_RESULT.DRAW,
                        "Sova",
                        "Diamond",
                        RANK_CHANGE.NO_CHANGE,
                        15,
                        15,
                        12,
                        1,
                        LocalDate.now(),
                        "https://www.youtube.com/embed/NY4WBM1Ujwc?si=vNaxN5pCDrEPlq8l",
                        "Haven",
                        0
                ));
            }
        };
    }
}
