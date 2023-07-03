package com.mysql.example.demo.controllers.nba;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.example.demo.responses.PlayerStatsNBADotCom;
import com.mysql.example.demo.responses.mobile.PlayerStatsNBADotComClientResponse;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IBackendRequestService;
import com.mysql.example.demo.services.clientRequestServices.interfaces.IPlayerService;

@RestController
public class PlayerStatsDashboardNBADotComController {

    private final IBackendRequestService requests;
    private final IPlayerService playerService;

    @Autowired
    public PlayerStatsDashboardNBADotComController(IBackendRequestService requests, IPlayerService playerService) {
        this.requests = requests;
        this.playerService = playerService;
    }

    @RequestMapping(value = "/nba/player/statsByYear", method=RequestMethod.GET)
    public ResponseEntity<PlayerStatsNBADotComClientResponse> getPlayerProfile(@RequestHeader(value = "playerID", required = true) String playerID) {

        Map<String, PlayerStatsNBADotCom> playerStats = requests.PlayerCareerStats(playerID);
        return playerService.returnPlayerStatsDashboardFromNBADotCom(playerID, playerStats);
    }
}
