package com.mysql.example.demo.controllers.nba.tasks;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mysql.example.demo.responses.PlayerStatsNBADotCom;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IBackendRequestService;
import com.mysql.example.demo.services.clientRequestServices.interfaces.IPlayerService;

@Component
public class NBADotComPlayerStatsDashboardTask {

    private final IBackendRequestService requests;
    private final IPlayerService playerService;

    @Autowired
    public NBADotComPlayerStatsDashboardTask(IPlayerService playerService, IBackendRequestService requests) {
        this.playerService = playerService;
        this.requests = requests;
    }

    //@Scheduled(fixedRate = 5000)
    public void getAllActivePlayerNBADotComStats() {
        try {
            List<Integer> listOfPlayerIDs = playerService.returnAllPlayerIds();
            playerService.dropCollection("NBADotComPlayerStats_Task");
            for (Integer a : listOfPlayerIDs) {
                Map<String, PlayerStatsNBADotCom> playerStats = requests.PlayerCareerStats(a.toString());
                playerService.saveOverallBasePlayerDashboardFromNBADotCom(a, playerStats);
            }
            System.out.println("Player saved to collection");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
