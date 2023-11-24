package com.project.sbws.backend.controllers.nba;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sbws.backend.responses.PlayerByTeamResponse;
import com.project.sbws.backend.responses.mobile.PlayerByTeamMobileResponse;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IBackendRequestService;
import com.project.sbws.backend.services.clientRequestServices.interfaces.IPlayerService;



@RestController
public class PlayerByGameController {
    private final IBackendRequestService requests;
    private final IPlayerService playerService;

    @Autowired
    public PlayerByGameController(IBackendRequestService requests, IPlayerService playerService) {
        this.requests = requests;
        this.playerService = playerService;
    }


    @RequestMapping(value = "/nba/playersByTeam/", method=RequestMethod.GET)
    public ResponseEntity<List<PlayerByTeamMobileResponse>> getPlayerProfile(@RequestParam String team, @RequestParam String key) {
       try {
        List<PlayerByTeamResponse> roster = requests.PlayerByTeamResponse_Get(key, team);
            return playerService.returnPlayerRosterByTeam(roster);
        } catch (Exception e) {
           e.printStackTrace();
       }
       
        return null;
        
    }
}

