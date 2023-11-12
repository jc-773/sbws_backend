package com.mysql.example.demo.controllers.nba;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerStatsNBADotCom;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponse;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IBackendRequestService;
import com.mysql.example.demo.services.clientRequestServices.interfaces.IPlayerService;
import com.mysql.example.demo.services.dataServices.interfaces.IPlayerProfileDataLayerService;

@RestController
public class PlayerController {
    private final IBackendRequestService requests;
    private final IPlayerService playerService;
    private final IPlayerProfileDataLayerService playerDataService;

    @Autowired
    public PlayerController(IBackendRequestService requests, IPlayerService playerService, 
     IPlayerProfileDataLayerService playerDataService) {
        this.requests = requests;
        this.playerService = playerService;
        this.playerDataService = playerDataService;
    }


    @RequestMapping(value = "/nba/players", method=RequestMethod.GET)
    public ResponseEntity<PlayerProfileResponse> getPlayerProfile(@RequestHeader(value = "Ocp-Apim-Subscription-Key") String sdToken, @RequestHeader(value = "X-RapidAPI-Key") String token, 
    @RequestHeader(value = "X-RapidAPI-Host", required = true) String host, @RequestHeader String playerID, @RequestHeader(value = "playerFirstName", required = false) String playerFirstName, @RequestHeader(value = "playerLastName", required = false) String playerLastName, @RequestHeader(value = "date", required = false) String date) {
       try {
           Map<String, PlayerStatsNBADotCom> playerStats = requests.PlayerCareerStats(playerID);
           Map<String,PlayerProjectionResponse> playerProjectionResponse =  requests.PlayerProjection_Get(sdToken, playerID, date);
          return playerService.returnPlayerProfileFromBackend(playerID, playerProjectionResponse, playerStats);
        } catch (Exception e) {
           e.printStackTrace();
       }
        return null;
    }

   

}

