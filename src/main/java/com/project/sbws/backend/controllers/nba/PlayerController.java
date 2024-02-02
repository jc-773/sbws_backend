package com.project.sbws.backend.controllers.nba;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sbws.backend.responses.PlayerProjectionResponse;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.responses.mobile.PlayerProfileResponse;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IBackendRequestService;
import com.project.sbws.backend.services.clientRequestServices.interfaces.IPlayerService;
import com.project.sbws.backend.services.dataServices.interfaces.IPlayerProfileDataLayerService;


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
    public ResponseEntity<PlayerProfileResponse> getPlayerProfile(
    @RequestHeader(value = "playerID", required = false)String playerID,
    @RequestHeader(value = "date", required = false) String date, 
    @RequestParam(value = "key", required = true) String key) {
       try {
           List<PlayerProjectionResponse> playerProjectionResponse =  requests.PlayerProjectionByDate_Get(key, date);
           //separate call for database services?
          return playerService.returnPlayerProfileFromBackend(playerID, playerProjectionResponse, null);
        } catch (Exception e) {
           e.printStackTrace();
       }
        return null;
    }

   

}

