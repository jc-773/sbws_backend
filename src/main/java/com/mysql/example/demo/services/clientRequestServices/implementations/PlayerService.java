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
import com.mysql.example.demo.responses.ParametersNBADotCom;
import com.mysql.example.demo.responses.PlayerByTeamResponse;
import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerStatsNBADotCom;
import com.mysql.example.demo.responses.ResultSets;
import com.mysql.example.demo.responses.containers.PlayerByTeamContainer;
import com.mysql.example.demo.responses.containers.PlayerResponseContainer;
import com.mysql.example.demo.responses.database.PlayerStatsNBADotComDocument;
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
            PlayerProjectionResponse playerProjectionResponse, Map<String, PlayerStatsNBADotCom> playerStats ) {
        try {
            
            String jsonString = new ObjectMapper().writeValueAsString(playerStats);
            ObjectMapper mapper = new ObjectMapper();
            PlayerStatsNBADotCom readValue = mapper.readValue(jsonString, PlayerStatsNBADotCom.class);
            //List<Object> resultsSet = readValue.resultSets;
            ArrayList<String> keys = new ArrayList<>();
            ArrayList<String> keys2 = new ArrayList<>();

            ArrayList<String> values = new ArrayList<>();
            ArrayList<Object> values2 = new ArrayList<>();

            Map<Integer, Object> resultSetMap = new HashMap<>();

            for(  Map.Entry<String, PlayerStatsNBADotCom> entry : playerStats.entrySet()) {
              System.out.println("Dis da entry: " + entry);
              
             String a = "";
              if( entry.getKey().equals("resultSets")) {
                a = entry.getKey();
                List<Map<String, PlayerStatsNBADotCom>> b = (List<Map<String, PlayerStatsNBADotCom>>) entry.getValue();
                System.out.println("Object" + b);
                for(Map.Entry<String, PlayerStatsNBADotCom> entryX : b.get(0).entrySet()) {
                    String key = entryX.getKey();
                    keys.add(key);
                    if(key.equals("headers")) {
                        List<String> za = (List<String>) entryX.getValue();
                        // for(Map.Entry<String, PlayerStatsNBADotCom> entryXX : entryX.getValue()) {
                        //     System.out.println(entryXX);
                        // }
                       //ResultSets aa = entryX.getValue();
                       for(String q : za) {
                        keys2.add(q);
                        //resultSetMap.put(q, null);
                       }
                       String groupSet = keys2.get(0);
                       System.out.println("GroupSet: " + groupSet);
                    }
                    System.out.println("Object" + b);

                    if(key.equals("rowSet")) {
                        List<Object> za = (List<Object>) entryX.getValue();
                       for(Object q : za) {
                        List<Object> y = (List<Object>)q;
                        for(int i = 0; i < y.size(); i++) {
                            resultSetMap.put(i, y.get(i));

                        }
                        //p.AST = zas.get(0).AST;
                        values2.add(q);
                       }
                       //String groupSet = values2.get(0);
                      // System.out.println("GroupSet: " + groupSet);
                    }
                }
              }
              System.out.println(a);
            }
            PlayerProfileResponse playerProfileClientResponse = new PlayerProfileResponse();
            playerProfileClientResponse.playerProfileResponseType = new ArrayList<>();
            playerProfileClientResponse.playerProfileResponseType.add(new PlayerProfileResponseType());

            PlayerResponseContainer playerBackendResponse = playerProfileDataService.findPlayerByPlayerID(playerID);
            buildPlayerProfileBasicInformation(playerProfileClientResponse.playerProfileResponseType.get(0), playerBackendResponse);
            buildPlayerProfileProjectionsClientResponse(playerProfileClientResponse.playerProfileResponseType.get(0),
                    playerProjectionResponse);

            return new ResponseEntity<PlayerProfileResponse>(playerProfileClientResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO: Could probably be move to a utility class of some sort 
    private static void buildPlayerProfileBasicInformation(PlayerProfileResponseType playerProfileClientResponseType,
            PlayerResponseContainer playerBackendResponse) {
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

     // @Deprecated
    // @Override
    // public ResponseEntity<PlayerProfileResponse> returnPlayerProfile(List<PlayerResponse> playerResponse,
    //         String playerFirstName, String playerLastName, PlayerProjectionResponse playerProjectionResponse) {

    //     try {
    //         PlayerProfileResponse playerProfileResponse = buildPlayerProfileResponse(playerFirstName, playerLastName,
    //                 playerProjectionResponse);

    //         // TODO: Make generic to use across all response objects
    //         Map<String, List<PlayerResponse>> playerProfMap = new HashMap<>();
    //         playerProfMap.put("key", playerResponse);
    //         String jsonString = new ObjectMapper().writeValueAsString(playerProfMap);
    //         ObjectMapper mapper = new ObjectMapper();
    //         PlayerResponse readValue = mapper.readValue(jsonString, PlayerResponse.class);
    //         String firstName = playerProfileResponse.playerProfileResponseType.get(0).firstName;
    //         String lastName = playerProfileResponse.playerProfileResponseType.get(0).lastName;
    //         for (int i = 0; i < readValue.response.size(); i++) {
    //             if (readValue.response.get(i).firstName.equalsIgnoreCase(firstName)
    //                     && readValue.response.get(i).lastName.equalsIgnoreCase(lastName)) {
    //                 playerProfileResponse.playerProfileResponseType.get(0).playerID = readValue.response
    //                         .get(i).playerID;
    //                 playerProfileResponse.playerProfileResponseType.get(0).status = readValue.response.get(i).status;
    //                 playerProfileResponse.playerProfileResponseType.get(0).team = readValue.response.get(i).team;
    //                 playerProfileResponse.playerProfileResponseType.get(0).position = readValue.response
    //                         .get(i).position;
    //             }

    //         }

    //         playerProfileDataService.savePlayer(playerProfileResponse.playerProfileResponseType.get(0));
    //         return new ResponseEntity<PlayerProfileResponse>(playerProfileResponse, HttpStatus.OK);

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }

    // @Deprecated 
    // @Override
    // public String getPlayerIdForProjectiions(List<PlayerResponse> playerResponse, String playerFirstName,
    //         String playerLastName) {
    //     PlayerProfileResponse playerProfileResponse = new PlayerProfileResponse();
    //     playerProfileResponse.playerProfileResponseType = new ArrayList();
    //     playerProfileResponse.playerProfileResponseType.add(new PlayerProfileResponseType());
    //     playerProfileResponse.playerProfileResponseType.get(0).firstName = playerFirstName;
    //     playerProfileResponse.playerProfileResponseType.get(0).lastName = playerLastName;
    //     try {
    //         Map<String, List<PlayerResponse>> playerProfMap = new HashMap<>();
    //         playerProfMap.put("key", playerResponse);
    //         String jsonString = new ObjectMapper().writeValueAsString(playerProfMap);
    //         ObjectMapper mapper = new ObjectMapper();
    //         PlayerResponse readValue = mapper.readValue(jsonString, PlayerResponse.class);
    //         String firstName = playerProfileResponse.playerProfileResponseType.get(0).firstName;
    //         String lastName = playerProfileResponse.playerProfileResponseType.get(0).lastName;
    //         for (int i = 0; i < readValue.response.size(); i++) {
    //             if (readValue.response.get(i).firstName.equalsIgnoreCase(firstName)
    //                     && readValue.response.get(i).lastName.equalsIgnoreCase(lastName)) {
    //                 playerProfileResponse.playerProfileResponseType.get(0).playerID = readValue.response
    //                         .get(i).playerID;
    //             }
    //         }

    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }

    //     return playerProfileResponse.playerProfileResponseType.get(0).playerID;
    // }

    
}
