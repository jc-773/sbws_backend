package com.project.sbws.backend.controllers.nba;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.sbws.backend.responses.NBADotComPlayerStatsRowSet;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.services.implementation.NBAPlayerStatsService;
import com.project.sbws.backend.services.implementation.requests.NBAPlayerRequestService;
import com.project.sbws.backend.services.interfaces.INBAPlayerStatsService;
import com.project.sbws.backend.services.interfaces.requests.INBAPlayerRequestService;


@RestController
public class PlayerStatsBySeason {
    
    private final INBAPlayerRequestService nPlayerRequestService;
    private final INBAPlayerStatsService playerStatsService;
   

    @Autowired
    public PlayerStatsBySeason(NBAPlayerRequestService nPlayerRequestService, NBAPlayerStatsService playerStatsService) {
        this.nPlayerRequestService = nPlayerRequestService;
        this.playerStatsService = playerStatsService;
    }

    @RequestMapping(value = "/nba/player/stats/byseason", method=RequestMethod.GET)
     public ResponseEntity <List<NBADotComPlayerStatsRowSet>> getPlayerStatsBySeason(@RequestHeader(value = "playerID", required = false)String playerID) {
        try {
                Map<String, PlayerStatsNBADotCom> playerStats = nPlayerRequestService.PlayerCareerStats(playerID);
                return playerStatsService.getPlayerCareerStats(playerStats);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }
}
