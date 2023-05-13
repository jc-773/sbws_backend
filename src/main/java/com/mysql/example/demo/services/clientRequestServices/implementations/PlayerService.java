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
import com.mysql.example.demo.repositories.PlayerProfileRepository;
import com.mysql.example.demo.responses.PlayerByTeamResponse;
import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.containers.PlayerByTeamContainer;
import com.mysql.example.demo.responses.containers.PlayerResponseContainer;
import com.mysql.example.demo.responses.mobile.PlayerByTeamMobileResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponseType;
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
            PlayerProjectionResponse playerProjectionResponse) {
        try {

            PlayerResponseContainer playerBackendResponse = playerProfileDataService.findPlayerByPlayerID(playerID);
            PlayerProfileResponse playerProfileClientResponse = new PlayerProfileResponse();
            playerProfileClientResponse.playerProfileResponseType = new ArrayList<>();
            playerProfileClientResponse.playerProfileResponseType.add(new PlayerProfileResponseType());

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
