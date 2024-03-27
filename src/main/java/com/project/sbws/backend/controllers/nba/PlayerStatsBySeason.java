package com.project.sbws.backend.controllers.nba;

import java.sql.ResultSet;
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
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IBackendRequestService;
import com.project.sbws.backend.services.clientRequestServices.implementations.NBAPlayerStatsService;

@RestController
public class PlayerStatsBySeason {
    
    IBackendRequestService backendRequestService;
    NBAPlayerStatsService playerStatsService;

    @Autowired
    public PlayerStatsBySeason(IBackendRequestService backendRequestService) {
        this.backendRequestService = backendRequestService;
        this.playerStatsService = new NBAPlayerStatsService();
    }

    @RequestMapping(value = "/nba/player/stats/byseason", method=RequestMethod.GET)
     public ResponseEntity <List<NBADotComPlayerStatsRowSet>> getPlayerStatsBySeason(@RequestHeader(value = "playerID", required = false)String playerID) {
        try {
                Map<String, PlayerStatsNBADotCom> playerStats = backendRequestService.PlayerCareerStats(playerID);
                return playerStatsService.getPlayerCareerStats(playerStats);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }
}
