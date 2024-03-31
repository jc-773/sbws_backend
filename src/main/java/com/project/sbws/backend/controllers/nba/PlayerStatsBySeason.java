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
import com.project.sbws.backend.services.implementation.NBAPlayerStatsService;
import com.project.sbws.backend.services.implementation.redis.RedisPlayerStatsBySeasonService;
import com.project.sbws.backend.services.interfaces.IBackendRequestService;


@RestController
public class PlayerStatsBySeason {
    
    IBackendRequestService backendRequestService;
    NBAPlayerStatsService playerStatsService;
    private RedisPlayerStatsBySeasonService redisPlayerStatsBySeasonService;
   

    @Autowired
    public PlayerStatsBySeason(IBackendRequestService backendRequestService, RedisPlayerStatsBySeasonService redisPlayerStatsBySeasonService) {
        this.backendRequestService = backendRequestService;
        this.playerStatsService = new NBAPlayerStatsService();
        this.redisPlayerStatsBySeasonService = redisPlayerStatsBySeasonService;
    }

    @RequestMapping(value = "/nba/player/stats/byseason", method=RequestMethod.GET)
     public ResponseEntity <List<NBADotComPlayerStatsRowSet>> getPlayerStatsBySeason(@RequestHeader(value = "playerID", required = false)String playerID) {
        try {
                Map<String, PlayerStatsNBADotCom> playerStats = backendRequestService.PlayerCareerStats(playerID);
                List<NBADotComPlayerStatsRowSet> basePlayerDashboardByYear = playerStatsService.filterPlayerStatsMapToBasePlayerDashboard(playerStats);
                redisPlayerStatsBySeasonService.savePlayerStatsBySeason(playerID, null);
                return playerStatsService.getPlayerCareerStats(playerID, playerStats);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }
}
