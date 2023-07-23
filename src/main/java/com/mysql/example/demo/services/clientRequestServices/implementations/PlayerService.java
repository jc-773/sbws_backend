package com.mysql.example.demo.services.clientRequestServices.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.mysql.example.demo.services.dataServices.implementations.PlayerProfileDataService;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    PlayerProfileDataService playerProfileDataService;

    // Implementations
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
                PlayerByTeamMobileResponse playerByTeamMobileResponse = new PlayerByTeamMobileResponse();
                playerByTeamMobileResponse.firstName = player.firstName;
                playerByTeamMobileResponse.lastName = player.lastName;
                playerByTeamMobileResponse.position = player.position;
                playerByTeamMobileResponse.status = player.status;
                playerByTeamMobileResponse.playerID = player.playerID;
                playerByTeamMobileResponse.teamID = player.teamID;
                playersByTeamList.add(playerByTeamMobileResponse);
            }
            return new ResponseEntity<List<PlayerByTeamMobileResponse>>(playersByTeamList, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

    @Override
    public void storeListOfPlayersOnTeam(List<PlayerByTeamResponse> roster) {
       try {
            Map<String, List<PlayerByTeamResponse>> playerByTeamResponse = new HashMap<>();
            playerByTeamResponse.put("key", roster);
            String jsonString = new ObjectMapper().writeValueAsString(playerByTeamResponse);
            ObjectMapper mapper = new ObjectMapper();
            PlayerByTeamContainer readValue = mapper.readValue(jsonString, PlayerByTeamContainer.class);
            List<PlayerByTeamMobileResponse> playersByTeamList = new ArrayList<>();
            for (PlayerByTeamResponse player : readValue.response) {
                PlayerByTeamMobileResponse playerByTeamMobileResponse = new PlayerByTeamMobileResponse();
                playerByTeamMobileResponse.firstName = player.firstName;
                playerByTeamMobileResponse.lastName = player.lastName;
                playerByTeamMobileResponse.position = player.position;
                playerByTeamMobileResponse.status = player.status;
                playerByTeamMobileResponse.playerID = player.playerID;
                playerByTeamMobileResponse.teamID = player.teamID;
                playerByTeamMobileResponse.nbaDotComPlayerID = player.nbaDotComPlayerID;
                playerByTeamMobileResponse.fanDuelPlayerID = player.fanDuelPlayerID;
                playerByTeamMobileResponse.fanDuelName = player.fanDuelName;
                playerByTeamMobileResponse.fantasyAlarmPlayerID = player.fantasyAlarmPlayerID;
                playerByTeamMobileResponse.draftKingsPlayerID = player.draftKingsPlayerID;
                playerByTeamMobileResponse.draftKingsName = player.draftKingsName;
                playerByTeamMobileResponse.rotoWirePlayerID = player.rotoWirePlayerID;
                playersByTeamList.add(playerByTeamMobileResponse);
            }
            playerProfileDataService.savePlayersByTeam(playersByTeamList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlayerByTeamCollectionForNewInstances() {
        playerProfileDataService.deletePlayerByTeamCollectionForNewInstances();
    }

    @Override
    public ResponseEntity<PlayerProfileResponse> returnPlayerProfileFromBackend(String playerID,
            Map<String, PlayerProjectionResponse> playerProjectionResponse,
            Map<String, PlayerStatsNBADotCom> playerStats) {
        try {
            PlayerProjectionResponse playerProjectionResponseReadValue = flattenPlayerProjectionMap(
                    playerProjectionResponse);

            //uses the data service to find player by playerID in the mongo database
            PlayerResponseContainer playerBackendResponse = playerProfileDataService.findPlayerByPlayerID(playerID);
            PlayerProfileResponse playerProfileResponse = buildPlayerProfileBasicInformation(playerBackendResponse, playerProjectionResponseReadValue);
            // if(playerProfileResponse != null && playerProfileResponse.playerProfileResponseType != null) {
            //     playerProfileDataService.savePlayer(playerProfileResponse.playerProfileResponseType.get(0));
            // }

            return new ResponseEntity<PlayerProfileResponse>(playerProfileResponse, HttpStatus.OK);
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
            Map<String, Object> overallBasePlayerDashboard_NBADotCom_Map = processJsonForOverallBasePlayerDashboardMap(
                    playerStat, playerID);

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

    private static PlayerProfileResponse buildPlayerProfileBasicInformation(PlayerResponseContainer playerBackendResponse, PlayerProjectionResponse playerProjectionResponseReadValue) {
        if (playerBackendResponse != null) {
            PlayerProfileResponse playerProfileClientResponse = new PlayerProfileResponse();
            playerProfileClientResponse.playerProfileResponseType = new ArrayList<>();
            playerProfileClientResponse.playerProfileResponseType.add(new PlayerProfileResponseType());
            playerProfileClientResponse.playerProfileResponseType.get(0).playerID = playerBackendResponse.playerID;
            playerProfileClientResponse.playerProfileResponseType.get(0).draftKindsPlayerID = playerBackendResponse.draftKingsPlayerID;
            playerProfileClientResponse.playerProfileResponseType.get(0).fanDuelPlayerID = playerBackendResponse.fanDuelPlayerID;
            playerProfileClientResponse.playerProfileResponseType.get(0).nbaDotComPlayerID = playerBackendResponse.nbaDotComPlayerID;
            playerProfileClientResponse.playerProfileResponseType.get(0).rotoWirePlayerID = playerBackendResponse.rotoWirePlayerID;
            playerProfileClientResponse.playerProfileResponseType.get(0).teamID = playerBackendResponse.teamID;
            playerProfileClientResponse.playerProfileResponseType.get(0).firstName = playerBackendResponse.firstName;
            playerProfileClientResponse.playerProfileResponseType.get(0).lastName = playerBackendResponse.lastName;
            playerProfileClientResponse.playerProfileResponseType.get(0).position = playerBackendResponse.position;

            if(playerProjectionResponseReadValue != null) {
                playerProfileClientResponse.playerProfileResponseType.get(0).projectedPoints = playerProjectionResponseReadValue.points;
                playerProfileClientResponse.playerProfileResponseType.get(0).projectedAssists = playerProjectionResponseReadValue.assists;
                playerProfileClientResponse.playerProfileResponseType.get(0).projectedRebounds = playerProjectionResponseReadValue.rebounds;
                playerProfileClientResponse.playerProfileResponseType.get(0).projectedThreesMade = playerProjectionResponseReadValue.threePointersMade;
            }
            return playerProfileClientResponse;
        }
        return null;
    }

    private Map<String, Object> processJsonForOverallBasePlayerDashboardMap(Map<String, PlayerStatsNBADotCom> map,
            String playerID) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.putIfAbsent("playerID", playerID);
            String playerStatsJsonString = new ObjectMapper().writeValueAsString(map);
            PlayerStatsNBADotCom readValue = mapper.readValue(playerStatsJsonString, PlayerStatsNBADotCom.class);

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

    private PlayerProjectionResponse flattenPlayerProjectionMap(Map<String, PlayerProjectionResponse> map) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String playerProjectionJsonString = new ObjectMapper().writeValueAsString(map);
            return mapper.readValue(playerProjectionJsonString,
                    PlayerProjectionResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}
