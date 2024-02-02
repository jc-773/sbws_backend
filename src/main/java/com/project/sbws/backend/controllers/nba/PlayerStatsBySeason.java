package com.project.sbws.backend.controllers.nba;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.responses.mobile.PlayerProfileResponse;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IBackendRequestService;

@RestController
public class PlayerStatsBySeason {
    
    IBackendRequestService backendRequestService;

    @Autowired
    public PlayerStatsBySeason(IBackendRequestService backendRequestService) {
        this.backendRequestService = backendRequestService;
    }

    @RequestMapping(value = "/nba/player/stats/byseason", method=RequestMethod.GET)
     public ResponseEntity<PlayerStatsNBADotCom> getPlayerStatsBySeason(@RequestHeader(value = "playerID", required = false)String playerID) {
        try {
                Map<String, PlayerStatsNBADotCom> playerStats = backendRequestService.PlayerCareerStats(playerID);
                System.out.println(playerStats);

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
     }
}
