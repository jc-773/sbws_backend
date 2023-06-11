package com.mysql.example.demo.controllers.nba;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.PlayerStatsNBADotCom;
import com.mysql.example.demo.responses.ResultStatsNBADotCom;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponse;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IBackendRequestService;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IPlayerProfileDataLayerService;
import com.mysql.example.demo.services.clientRequestServices.interfaces.IPlayerResponseService;
import com.mysql.example.demo.services.clientRequestServices.interfaces.IPlayerService;

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
    @RequestHeader(value = "X-RapidAPI-Host") String host, @RequestHeader String playerID, @RequestHeader(value = "playerFirstName", required = false) String playerFirstName, @RequestHeader(value = "playerLastName", required = false) String playerLastName, @RequestHeader(value = "date", required = false) String date) {
       try {
        ObjectMapper mapper = new ObjectMapper();
           //TODO: Make an async background task 
            // List<PlayerResponse> playerResponse =  requests.PlayerInformation_Get(sdToken);
            // playerDataService.savePlayers(playerResponse);
           //String playerID = playerService.getPlayerIdForProjectiions(playerResponse, playerFirstName, playerLastName);
           Map<String, PlayerStatsNBADotCom> playerStats = requests.PlayerCareerStats();
        //    String jsonString = new ObjectMapper().writeValueAsString(playerStats);
        //    PlayerStatsNBADotCom readValue = mapper.readValue(jsonString, PlayerStatsNBADotCom.class);
        //    ArrayList<ResultStatsNBADotCom> list = new ArrayList<>();
        //    list.add( readValue.resultSets.get(0));
       // ArrayList<String> resultSetsList = playerStats.get(0).resultSets.get(0).headers;
          PlayerProjectionResponse playerProjectionResponse =  requests.PlayerProjection_Get(sdToken, playerID, date);
           return playerService.returnPlayerProfileFromBackend(playerID, playerProjectionResponse, playerStats);
          //return null;
        } catch (Exception e) {
           e.printStackTrace();
       }
        return null;
    }

   

}

