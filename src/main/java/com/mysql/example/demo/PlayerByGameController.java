package com.mysql.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.example.demo.responses.PlayerByTeamResponse;
import com.mysql.example.demo.responses.mobile.PlayerByTeamMobileResponse;
import com.mysql.example.demo.services.interfaces.IBackendRequestService;

@RestController
public class PlayerByGameController {
    private final IBackendRequestService requests;
    private final IPlayerService playerService;
    private final IPlayerResponseService responseEntity;

    @Autowired
    public PlayerByGameController(IBackendRequestService requests, IPlayerService playerService, IPlayerResponseService responseEntity) {
        this.requests = requests;
        this.playerService = playerService;
        this.responseEntity = responseEntity;
    }


    @RequestMapping(value = "/nba/playersByTeam/", method=RequestMethod.GET)
    public ResponseEntity<List<PlayerByTeamMobileResponse>> getPlayerProfile(@RequestParam String team, @RequestParam String key) {
       try {
        List<PlayerByTeamResponse> roster = requests.PlayerByTeamResponse_Get(key, team);
            return playerService.returnPlayerRosterByTeam(roster);
            
           //return playerService.returnPlayerProfile(playerResponse, playerFirstName, playerLastName, playerProjectionResponse);
        } catch (Exception e) {
           e.printStackTrace();
       }
       
        return null;
        
    }
}
