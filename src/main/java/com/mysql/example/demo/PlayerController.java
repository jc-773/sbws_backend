package com.mysql.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponse;
import com.mysql.example.demo.services.interfaces.IBackendRequestService;
import com.mysql.example.demo.services.interfaces.IPlayerProfileDataLayerService;

@RestController
public class PlayerController {
    private final IBackendRequestService requests;
    private final IPlayerService playerService;
    private final IPlayerResponseService responseEntity;
    private final IPlayerProfileDataLayerService playerDataService;

    @Autowired
    public PlayerController(IBackendRequestService requests, IPlayerService playerService, IPlayerResponseService responseEntity, IPlayerProfileDataLayerService playerDataService) {
        this.requests = requests;
        this.playerService = playerService;
        this.responseEntity = responseEntity;
        this.playerDataService = playerDataService;
    }


    @RequestMapping(value = "/nba/players", method=RequestMethod.GET)
    public ResponseEntity<PlayerProfileResponse> getPlayerProfile(@RequestHeader(value = "Ocp-Apim-Subscription-Key") String sdToken, @RequestHeader(value = "X-RapidAPI-Key") String token, 
    @RequestHeader(value = "X-RapidAPI-Host") String host, @RequestHeader String playerFirstName, @RequestHeader String playerLastName) {
       try {
           List<PlayerResponse> playerResponse =  requests.PlayerInformation_Get(sdToken);
           String playerID = playerService.getPlayerIdForProjectiions(playerResponse, playerFirstName, playerLastName);
           PlayerProjectionResponse playerProjectionResponse =  requests.PlayerProjection_Get(sdToken, playerID, "2023-04-08");
           return playerService.returnPlayerProfile(playerResponse, playerFirstName, playerLastName, playerProjectionResponse);
        } catch (Exception e) {
           e.printStackTrace();
       }
       
        return null;
        
    }

   

}
