package com.mysql.example.demo.controllers.nba;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.example.demo.responses.PlayerStatsNBADotCom;
import com.mysql.example.demo.responses.mobile.PlayerStatsNBADotComClientResponse;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IBackendRequestService;

@RestController
public class PlayerStatsDashboardNBADotComController {

    private final IBackendRequestService requests;

    @Autowired
    public PlayerStatsDashboardNBADotComController(IBackendRequestService requests) {
        this.requests = requests;
    }

    @RequestMapping(value = "/nba/player/statsByYear", method=RequestMethod.GET)
    public ResponseEntity<PlayerStatsNBADotComClientResponse> getPlayerProfile() {

        Map<String, PlayerStatsNBADotCom> playerStats = requests.PlayerCareerStats();
        return null;
    }
}
