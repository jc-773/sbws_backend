package com.mysql.example.demo.services.clientRequestServices.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.example.demo.responses.ParametersNBADotCom;
import com.mysql.example.demo.responses.PlayerByTeamResponse;
import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerStatsNBADotCom;
import com.mysql.example.demo.responses.containers.PlayerByTeamContainer;
import com.mysql.example.demo.responses.containers.PlayerResponseContainer;
import com.mysql.example.demo.responses.mobile.PlayerByTeamMobileResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponseType;
import com.mysql.example.demo.responses.mobile.PlayerStatsNBADotComClientResponse;
import com.mysql.example.demo.services.clientRequestServices.interfaces.IPlayerService;
import com.mysql.example.demo.services.dataServices.PlayerProfileDataService;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    PlayerProfileDataService playerProfileDataService;

    // Implementations
    @Deprecated
    @Override
    public ResponseEntity<List<PlayerByTeamMobileResponse>> returnPlayerRosterByTeam(
            List<PlayerByTeamResponse> roster) {
        try {
            Map<String, List<PlayerByTeamResponse>> playerByTeamResponse = new HashMap<>();
            playerByTeamResponse.put("key", roster);
            String jsonString = new ObjectMapper().writeValueAsString(playerByTeamResponse);
            ObjectMapper mapper = new ObjectMapper();
            PlayerByTeamContainer readValue = mapper.readValue(jsonString, PlayerByTeamContainer.class);
            List<PlayerByTeamMobileResponse> playersByTeamList = new ArrayList<>();
            for (PlayerByTeamResponse player : readValue.response) {
                PlayerByTeamMobileResponse gamesByDateMobileResponse = new PlayerByTeamMobileResponse();
                gamesByDateMobileResponse.firstName = player.firstName;
                gamesByDateMobileResponse.lastName = player.lastName;
                gamesByDateMobileResponse.position = player.position;
                gamesByDateMobileResponse.status = player.status;
                gamesByDateMobileResponse.playerID = player.playerID;
                gamesByDateMobileResponse.teamID = player.teamID;
                playersByTeamList.add(gamesByDateMobileResponse);
            }
            return new ResponseEntity<List<PlayerByTeamMobileResponse>>(playersByTeamList, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

    @Override
    public ResponseEntity<PlayerProfileResponse> returnPlayerProfileFromBackend(String playerID,
            PlayerProjectionResponse playerProjectionResponse, Map<String, PlayerStatsNBADotCom> playerStats) {
        try {
            String jsonString = new ObjectMapper().writeValueAsString(playerStats);
            Map<String, Object> overallBasePlayerDashboard_NBADotCom_Map = processJsonForOverallBasePlayerDashboardMap(
                    jsonString, playerID);

            PlayerProfileResponse playerProfileClientResponse = new PlayerProfileResponse();
            playerProfileClientResponse.playerProfileResponseType = new ArrayList<>();
            playerProfileClientResponse.playerProfileResponseType.add(new PlayerProfileResponseType());

            PlayerResponseContainer playerBackendResponse = playerProfileDataService.findPlayerByPlayerID(playerID);
            buildPlayerProfileBasicInformation(playerProfileClientResponse.playerProfileResponseType.get(0),
                    playerBackendResponse);
            buildPlayerProfileProjectionsClientResponse(playerProfileClientResponse.playerProfileResponseType.get(0),
                    playerProjectionResponse);

            return new ResponseEntity<PlayerProfileResponse>(playerProfileClientResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<PlayerStatsNBADotComClientResponse> returnPlayerStatsDashboardFromNBADotCom(String playerID,
            Map<String, PlayerStatsNBADotCom> playerStat) {
        try {

            // Query by playerID and store into a response object
            // Once complete response is stored in an object, flatten to a client response
            // and return it here
            PlayerStatsNBADotComClientResponse playerStatsNBADotComClientResponse = new PlayerStatsNBADotComClientResponse();
            String jsonString = new ObjectMapper().writeValueAsString(playerStat);
            Map<String, Object> overallBasePlayerDashboard_NBADotCom_Map = processJsonForOverallBasePlayerDashboardMap(
                    jsonString, playerID);

                    ArrayList<String> listOfNBADotComBashboardStats = new ArrayList<>();
            Map<String, String> newMap = new HashMap<String, String>();
            for (Map.Entry<String, Object> entry : overallBasePlayerDashboard_NBADotCom_Map.entrySet()) {
                if (entry.getValue() instanceof Object) {
                    
                    newMap.put(entry.getKey(), (String) entry.getValue().toString());
                }
            }
          playerProfileDataService.saveOverallBasePlayerDashboardFromNBADotCom(newMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Utilities
    private static void buildPlayerProfileBasicInformation(PlayerProfileResponseType playerProfileClientResponseType,
            PlayerResponseContainer playerBackendResponse) {
        if (playerBackendResponse != null)
            playerProfileClientResponseType.firstName = playerBackendResponse.firstName;
        playerProfileClientResponseType.lastName = playerBackendResponse.lastName;
        playerProfileClientResponseType.position = playerBackendResponse.position;
    }

    private static void buildPlayerProfileProjectionsClientResponse(
            PlayerProfileResponseType playerProfileClientResponseType,
            PlayerProjectionResponse playerProjectionResponse) {
        if (playerProjectionResponse != null) {
            playerProfileClientResponseType.projectedPoints = playerProjectionResponse.points;
            playerProfileClientResponseType.projectedAssists = playerProjectionResponse.assists;
            playerProfileClientResponseType.projectedRebounds = playerProjectionResponse.rebounds;
            playerProfileClientResponseType.projectedThreesMade = playerProjectionResponse.threePointersMade;
        }
    }

    private Map<String, Object> processJsonForOverallBasePlayerDashboardMap(String jsonString, String playerID) {
        try {
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.putIfAbsent("playerID", playerID);
            ObjectMapper mapper = new ObjectMapper();
            PlayerStatsNBADotCom readValue = mapper.readValue(jsonString, PlayerStatsNBADotCom.class);

            // refactor to get every year and not just one year (the one year was POC)

            if (readValue.resultSets.size() > 0) {
                ArrayList<Object> rowSetList = readValue.resultSets.get(0).rowSet;
                ArrayList<String> headersList = readValue.resultSets.get(0).headers;
                for (Object oj : rowSetList) {
                    List<Object> ot = (List<Object>) oj;
                    for (int i = 0; i < ot.size(); i++) {
                        returnMap.put(headersList.get(i), ot.get(i));
                    }
                    // playerProfileDataService.saveOverallBasePlayerDashboardFromNBADotCom(returnMap);
                }
            }

            return returnMap;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
