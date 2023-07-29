package com.mysql.example.demo.services.dataServices.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.example.demo.repositories.AllPlayersOnAllTeamsRepository;
import com.mysql.example.demo.repositories.AllPlayersRepository;
import com.mysql.example.demo.repositories.PlayerProfileRepository;
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.containers.PlayerResponseContainer;
import com.mysql.example.demo.responses.mobile.PlayerByTeamMobileResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponseType;
import com.mysql.example.demo.services.dataServices.interfaces.IPlayerProfileDataLayerService;

@Service
public class PlayerProfileDataService implements IPlayerProfileDataLayerService {

    @Autowired
    PlayerProfileRepository playerProfileRepository;

    @Autowired
    AllPlayersRepository allPlayersRepository;

    @Autowired
    AllPlayersOnAllTeamsRepository allPlayersOnAllTeamsRepository;

    @Autowired
    private MongoTemplate mongo;

    @Override
    public void savePlayer(PlayerProfileResponseType playerProfileResponseType) {
        playerProfileRepository.save(playerProfileResponseType);
    }

    @Override
    public void savePlayers(List<PlayerResponse> playerResponse) {
        try {
            Map<String, List<PlayerResponse>> playerProfMap = new HashMap<>();
            playerProfMap.put("key", playerResponse);
            String jsonString = new ObjectMapper().writeValueAsString(playerProfMap);
            ObjectMapper mapper = new ObjectMapper();
            PlayerResponse readValue = mapper.readValue(jsonString, PlayerResponse.class);

            for (PlayerResponseContainer p : readValue.response) {
                allPlayersRepository.save(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PlayerResponseContainer findPlayerByPlayerID(String playerID) {
        try {
            PlayerResponseContainer player = allPlayersRepository.findPlayerByPlayerId(playerID);
            return player;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveOverallBasePlayerDashboardFromNBADotCom(Map<String, String> playerStatsMap) {
        Map<String, Object> playerStatsMapInstant = new HashMap<>(playerStatsMap);
        mongo.insert(playerStatsMapInstant, "NBADotComPlayerStats_Task");
    }

    @Override
    public void savePlayersByTeam(List<PlayerByTeamMobileResponse> playerResponse) {
        for (PlayerByTeamMobileResponse p : playerResponse) {
            allPlayersOnAllTeamsRepository.save(p);
        }
    }

    @Override
    public void deletePlayerByTeamCollectionForNewInstances() {
        allPlayersOnAllTeamsRepository.deleteAll();
    }

    @Override
    public List<Integer> returnAllPlayerIds() {
        try {
            Query query = new Query();
            query.fields().include("nbaDotComPlayerID");
            List<PlayerByTeamMobileResponse> listOfPlayers = mongo.find(query, PlayerByTeamMobileResponse.class);
            List<Integer> listOfPlayerIDs = new ArrayList<>();
            for(PlayerByTeamMobileResponse player : listOfPlayers) {
                listOfPlayerIDs.add(player.nbaDotComPlayerID);
            }
            return listOfPlayerIDs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
