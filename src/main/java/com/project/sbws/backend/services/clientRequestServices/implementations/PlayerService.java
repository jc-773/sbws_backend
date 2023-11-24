package com.project.sbws.backend.services.clientRequestServices.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.project.sbws.backend.responses.PlayerByTeamResponse;
import com.project.sbws.backend.responses.PlayerProjectionResponse;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.responses.containers.PlayerByTeamContainer;
import com.project.sbws.backend.responses.containers.PlayerResponseContainer;
import com.project.sbws.backend.responses.mobile.PlayerByTeamMobileResponse;
import com.project.sbws.backend.responses.mobile.PlayerProfileResponse;
import com.project.sbws.backend.responses.mobile.PlayerProfileResponseType;
import com.project.sbws.backend.services.clientRequestServices.interfaces.IPlayerService;
import com.project.sbws.backend.services.dataServices.implementations.PlayerProfileDataService;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    PlayerProfileDataService playerProfileDataService;

    /* Utilities */

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

    private void deletePlayerByTeamCollectionForNewInstances() {
        playerProfileDataService.deletePlayerByTeamCollectionForNewInstances();
    }

    /* Implementations */ 

    @Override //Players By Game Controller
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
                playerByTeamMobileResponse.draftKingsPlayerID = player.draftKingsPlayerID;
                playerByTeamMobileResponse.fanDuelPlayerID = player.fanDuelPlayerID;
                playerByTeamMobileResponse.nbaDotComPlayerID = player.nbaDotComPlayerID;
                playerByTeamMobileResponse.teamID = player.teamID;
                playersByTeamList.add(playerByTeamMobileResponse);
            }
            return new ResponseEntity<List<PlayerByTeamMobileResponse>>(playersByTeamList, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

    @Override //Player Controller 
    public ResponseEntity<PlayerProfileResponse> returnPlayerProfileFromBackend(String playerID,
            Map<String, PlayerProjectionResponse> playerProjectionResponse,
            Map<String, PlayerStatsNBADotCom> playerStats) {
        try {
            PlayerProjectionResponse playerProjectionResponseReadValue = flattenPlayerProjectionMap(
                    playerProjectionResponse);

            //uses the data service to find player by playerID in the mongo database
            PlayerResponseContainer playerBackendResponse = playerProfileDataService.findPlayerByPlayerID(playerID);
            PlayerProfileResponse playerProfileResponse = buildPlayerProfileBasicInformation(playerBackendResponse, playerProjectionResponseReadValue);

            return new ResponseEntity<PlayerProfileResponse>(playerProfileResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override //Players By Team Task 
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
            deletePlayerByTeamCollectionForNewInstances();
            playerProfileDataService.savePlayersByTeam(playersByTeamList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     @Override //NBA.com Player Stats Dashboard Task 
    public void saveOverallBasePlayerDashboardFromNBADotCom(Integer playerID, Map<String, PlayerStatsNBADotCom> playerStat) {
        try {

            // Query by playerID and store into a response object
            // Once complete response is stored in an object, flatten to a client response
            // and return it here
            Map<String, Object> overallBasePlayerDashboard_NBADotCom_Map = processJsonForOverallBasePlayerDashboardMap(
                    playerStat, playerID.toString());

            
            Map<String, String> newMap = new HashMap<String, String>();
            for (Map.Entry<String, Object> entry : overallBasePlayerDashboard_NBADotCom_Map.entrySet()) {
                if (entry.getValue() instanceof Object) {

                    newMap.put(entry.getKey(), (String) entry.getValue().toString());
                }
            }

            //Find player firstName and lastName based on Player ID 
            PlayerByTeamMobileResponse playerBackendResponse = playerProfileDataService.findPlayerByNBADotComPlayerId(playerID);
            if(playerBackendResponse != null) {
                newMap.put("firstName", playerBackendResponse.firstName);
                newMap.put("lastName", playerBackendResponse.lastName);
            }
            
            playerProfileDataService.saveOverallBasePlayerDashboardFromNBADotCom(newMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override //NBA.com Player Stats Dashboard Task 
    public List<Integer> returnAllPlayerIds() {
       try {
        return playerProfileDataService.returnAllPlayerIds();
       } catch (Exception e) {
       e.printStackTrace();
       }
       return null;
    }

    @Override
    public void dropCollection(String collectionName) {
       playerProfileDataService.dropCollection(collectionName);
    }

   

    
}
