package com.project.sbws.backend.services.clientRequestServices.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.project.sbws.backend.responses.PlayerByTeamResponse;
import com.project.sbws.backend.responses.PlayerProjectionResponse;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.responses.containers.PlayerByTeamContainer;
import com.project.sbws.backend.responses.containers.PlayerProjectionContainer;
import com.project.sbws.backend.responses.containers.PlayerResponseContainer;
import com.project.sbws.backend.responses.mobile.PlayerByTeamMobileResponse;
import com.project.sbws.backend.responses.mobile.PlayerProfileResponse;
import com.project.sbws.backend.responses.mobile.PlayerProfileResponseType;
import com.project.sbws.backend.services.clientRequestServices.interfaces.IPlayerService;
import com.project.sbws.backend.services.dataServices.implementations.PlayerProfileDataService;
import com.project.sbws.backend.utilities.AppUtils;

@Service
public class PlayerService implements IPlayerService {

    // @Autowired
    // PlayerProfileDataService playerProfileDataService;

    /* Utilities */

    public static PlayerProfileResponse buildPlayerProfileBasicInformation(PlayerProjectionResponse playerProjectionResponse) {
        PlayerProfileResponse playerProfileClientResponse = null;
        if (playerProjectionResponse != null) {
            playerProfileClientResponse = new PlayerProfileResponse();
            playerProfileClientResponse.playerProfileResponseType = new PlayerProfileResponseType();
            playerProfileClientResponse.playerProfileResponseType.name = playerProjectionResponse.name;
            playerProfileClientResponse.playerProfileResponseType.position = playerProjectionResponse.position;
            playerProfileClientResponse.playerProfileResponseType.minutes = playerProjectionResponse.minutes;
            playerProfileClientResponse.playerProfileResponseType.fieldGoalsMade = playerProjectionResponse.fieldGoalsMade;
            playerProfileClientResponse.playerProfileResponseType.projectedPoints = playerProjectionResponse.points;
            playerProfileClientResponse.playerProfileResponseType.projectedAssists = playerProjectionResponse.assists;
            playerProfileClientResponse.playerProfileResponseType.projectedRebounds = playerProjectionResponse.rebounds;
            playerProfileClientResponse.playerProfileResponseType.projectedThreesMade = playerProjectionResponse.threePointersMade;
            playerProfileClientResponse.playerProfileResponseType.freeThrowsAttempted = playerProjectionResponse.freeThrowsAttempted;
            playerProfileClientResponse.playerProfileResponseType.freeThrowsMade = playerProjectionResponse.freeThrowsMade;
            playerProfileClientResponse.playerProfileResponseType.status = playerProjectionResponse.injuryStatus;
            
        }
        return playerProfileClientResponse;
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

    private <T> PlayerProjectionContainer flattenPlayerProjectionByDateMap(List<T> map) {
        try {

            Map<String, List<T>> playerProjectionResponse = new HashMap<>();
            playerProjectionResponse.put("key", map);
            String jsonString = new ObjectMapper().writeValueAsString(playerProjectionResponse);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonString, PlayerProjectionContainer.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PlayerProjectionResponse returnPlayerProfileMatchingPlayerID(
            PlayerProjectionContainer playerProjectionContainer, String playerID) {
        PlayerProjectionResponse filteredPlayerProjection = null;
        try {
            if (!AppUtils.isNullOrEmpty(playerID)) {
                int parsedPlayerID = AppUtils.parseStringToInt(playerID);

                PlayerProjectionResponse player = playerProjectionContainer.response
                        .stream().filter(n -> n.playerID == parsedPlayerID).findFirst()
                        .orElseThrow(() -> new Exception("unable to find player with playerID: " + playerID));
                filteredPlayerProjection = player;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredPlayerProjection;
    }

    public PlayerProjectionResponse getPlayerForPlayerProjectionByDate(
            PlayerProjectionContainer playerProjectionContainer, String playerID) {
        int parsedPlayerID;
        PlayerProjectionResponse filteredPlayerProjection = null;

        if (playerID != null || !playerID.isEmpty()) {
            parsedPlayerID = Integer.parseInt(playerID);

            Optional<PlayerProjectionResponse> player = playerProjectionContainer.response
                    .stream().filter(n -> n.playerID == parsedPlayerID).findFirst();

            if (player.get() != null) {
                filteredPlayerProjection = player.get();

            }
        }
        return filteredPlayerProjection;
    }

    // private void deletePlayerByTeamCollectionForNewInstances() {
    // playerProfileDataService.deletePlayerByTeamCollectionForNewInstances();
    // }

    /* Implementations */

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

    @Override
    public ResponseEntity<PlayerProfileResponse> returnPlayerProfileFromBackend(String playerID,
            List<PlayerProjectionResponse> playerProjectionResponse,
            Map<String, PlayerStatsNBADotCom> playerStats) {
        try {
            PlayerProjectionContainer playerProjectionContainerUnfiltered = flattenPlayerProjectionByDateMap(playerProjectionResponse);
            PlayerProjectionResponse playerProjectedResponseFiltered = returnPlayerProfileMatchingPlayerID(playerProjectionContainerUnfiltered, playerID);
            PlayerProfileResponse playerProfileResponse = buildPlayerProfileBasicInformation(playerProjectedResponseFiltered);

            return new ResponseEntity<PlayerProfileResponse>(playerProfileResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // Players By Team Task
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
            // deletePlayerByTeamCollectionForNewInstances();
            // playerProfileDataService.savePlayersByTeam(playersByTeamList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // NBA.com Player Stats Dashboard Task
    public void saveOverallBasePlayerDashboardFromNBADotCom(Integer playerID,
            Map<String, PlayerStatsNBADotCom> playerStat) {
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

            // Find player firstName and lastName based on Player ID
            // PlayerByTeamMobileResponse playerBackendResponse = playerProfileDataService
            // .findPlayerByNBADotComPlayerId(playerID);
            // if (playerBackendResponse != null) {
            // newMap.put("firstName", playerBackendResponse.firstName);
            // newMap.put("lastName", playerBackendResponse.lastName);
            // }

            // playerProfileDataService.saveOverallBasePlayerDashboardFromNBADotCom(newMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // NBA.com Player Stats Dashboard Task
    public List<Integer> returnAllPlayerIds() {
        try {
            // return playerProfileDataService.returnAllPlayerIds();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void dropCollection(String collectionName) {
        // playerProfileDataService.dropCollection(collectionName);
    }

}
