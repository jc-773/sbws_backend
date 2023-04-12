package com.mysql.example.demo;

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
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.containers.PlayerByTeamContainer;
import com.mysql.example.demo.responses.mobile.PlayerByTeamMobileResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponseType;

@Service
public class PlayerService implements IPlayerService {

    // @Autowired
    // TestRepository testRepository;

    // public PlayerService(TestRepository testRepository) {
    // this.testRepository = testRepository;
    // }

    @Override
    public Player savePlayer(List<PlayerResponse> playerResponse) {
        Player player = new Player();
        // player.name = playerResponse.get(0).response.get(0).firstName;
        // testRepository.save(player);

        return player;
    }

    @Override
    public ResponseEntity<PlayerProfileResponse> returnPlayerProfile(List<PlayerResponse> playerResponse,
            String playerFirstName, String playerLastName, PlayerProjectionResponse playerProjectionResponse) {

        try {
            PlayerProfileResponse playerProfileResponse = new PlayerProfileResponse();
            playerProfileResponse.playerProfileResponseType = new ArrayList();
            playerProfileResponse.playerProfileResponseType.add(new PlayerProfileResponseType());
            playerProfileResponse.playerProfileResponseType.get(0).firstName = playerFirstName;
            playerProfileResponse.playerProfileResponseType.get(0).lastName = playerLastName;
            playerProfileResponse.playerProfileResponseType.get(0).projectedPoints = playerProjectionResponse.points;
            playerProfileResponse.playerProfileResponseType.get(0).projectedAssists = playerProjectionResponse.assists;
            playerProfileResponse.playerProfileResponseType.get(0).projectedRebounds = playerProjectionResponse.rebounds;
            playerProfileResponse.playerProfileResponseType.get(0).projectedThreesMade = playerProjectionResponse.threePointersMade;

            // Find player by ID section
            Map<String, List<PlayerResponse>> playerProfMap = new HashMap<>();
            playerProfMap.put("key", playerResponse);
            String jsonString = new ObjectMapper().writeValueAsString(playerProfMap);
            ObjectMapper mapper = new ObjectMapper();
            PlayerResponse readValue = mapper.readValue(jsonString, PlayerResponse.class);
            String firstName = playerProfileResponse.playerProfileResponseType.get(0).firstName;
            String lastName = playerProfileResponse.playerProfileResponseType.get(0).lastName;
            for (int i = 0; i < readValue.response.size(); i++) {
                if (readValue.response.get(i).firstName.equalsIgnoreCase(firstName)
                        && readValue.response.get(i).lastName.equalsIgnoreCase(lastName)) {
                    playerProfileResponse.playerProfileResponseType.get(0).playerID = readValue.response
                            .get(i).playerID;
                    playerProfileResponse.playerProfileResponseType.get(0).status = readValue.response.get(i).status;
                    playerProfileResponse.playerProfileResponseType.get(0).team = readValue.response.get(i).team;
                    playerProfileResponse.playerProfileResponseType.get(0).position = readValue.response
                            .get(i).position;
                }

            }
            // News section
            // playerProfileResponse.playerProfileResponseType.get(0).playerNewsResponse =
            // playerNewsResponse;

            // //Projection section
            // AddPlayerProjectionsSection(playerProfileResponse, playerProjectionResponse);
            
            return new ResponseEntity<PlayerProfileResponse>(playerProfileResponse, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    

    @Override
    public String getPlayerIdForProjectiions(List<PlayerResponse> playerResponse, String playerFirstName,
            String playerLastName) {
        PlayerProfileResponse playerProfileResponse = new PlayerProfileResponse();
        playerProfileResponse.playerProfileResponseType = new ArrayList();
        playerProfileResponse.playerProfileResponseType.add(new PlayerProfileResponseType());
        playerProfileResponse.playerProfileResponseType.get(0).firstName = playerFirstName;
        playerProfileResponse.playerProfileResponseType.get(0).lastName = playerLastName;
        try {
            Map<String, List<PlayerResponse>> playerProfMap = new HashMap<>();
            playerProfMap.put("key", playerResponse);
            String jsonString = new ObjectMapper().writeValueAsString(playerProfMap);
            ObjectMapper mapper = new ObjectMapper();
            PlayerResponse readValue = mapper.readValue(jsonString, PlayerResponse.class);
            String firstName = playerProfileResponse.playerProfileResponseType.get(0).firstName;
            String lastName = playerProfileResponse.playerProfileResponseType.get(0).lastName;
            for (int i = 0; i < readValue.response.size(); i++) {
                if (readValue.response.get(i).firstName.equalsIgnoreCase(firstName)
                        && readValue.response.get(i).lastName.equalsIgnoreCase(lastName)) {
                    playerProfileResponse.playerProfileResponseType.get(0).playerID = readValue.response
                            .get(i).playerID;
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return playerProfileResponse.playerProfileResponseType.get(0).playerID;
    }

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
                for(PlayerByTeamResponse player : readValue.response) {
                    PlayerByTeamMobileResponse gamesByDateMobileResponse = new PlayerByTeamMobileResponse();
                    gamesByDateMobileResponse.firstName = player.firstName;
                    gamesByDateMobileResponse.lastName = player.lastName;
                    gamesByDateMobileResponse.position = player.position;
                    gamesByDateMobileResponse.status = player.status;
                    playersByTeamList.add(gamesByDateMobileResponse);
                }
                return new ResponseEntity<List<PlayerByTeamMobileResponse>>(playersByTeamList, HttpStatus.OK);
             } catch (Exception e) {
                // TODO: handle exception
             }

             return null;
    }

}
