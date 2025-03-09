package br.com.pvt.valorant.tracker.controller;

import br.com.pvt.valorant.tracker.core.model.statistics.PlayerStatisticsDto;
import br.com.pvt.valorant.tracker.service.PlayerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stats")
public class StatisticsController {

    private final PlayerStatisticsService statisticsService;

    @Autowired
    public StatisticsController(PlayerStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/overall")
    public String getOverallStats(Model model) {
        PlayerStatisticsDto statistics = statisticsService.getOverallStats();
        model.addAttribute("statistics", statistics);
        return "statistics";
    }
}
