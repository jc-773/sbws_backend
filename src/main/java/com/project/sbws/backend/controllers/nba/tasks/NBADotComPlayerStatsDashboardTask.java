package com.project.sbws.backend.controllers.nba.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.sbws.backend.services.interfaces.IBackendRequestService;
import com.project.sbws.backend.services.interfaces.IPlayerService;

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
    // public void getAllActivePlayerNBADotComStats() {
    //     try {
    //         List<Integer> listOfPlayerIDs = playerService.returnAllPlayerIds();
    //         playerService.dropCollection("NBADotComPlayerStats_Task");
    //         for (Integer a : listOfPlayerIDs) {
    //             Map<String, PlayerStatsNBADotCom> playerStats = requests.PlayerCareerStats(a.toString());
    //             playerService.saveOverallBasePlayerDashboardFromNBADotCom(a, playerStats);
    //         }
    //         System.out.println("Player saved to collection");
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }

    // }
}
