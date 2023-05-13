package com.mysql.example.demo.services.dataServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.example.demo.repositories.AllPlayersRepository;
import com.mysql.example.demo.repositories.PlayerProfileRepository;
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.containers.PlayerResponseContainer;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponseType;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IPlayerProfileDataLayerService;

@Service
public class PlayerProfileDataService implements IPlayerProfileDataLayerService {
  
    @Autowired
    PlayerProfileRepository playerProfileRepository;

    @Autowired
    AllPlayersRepository allPlayersRepository;

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

            for(PlayerResponseContainer p : readValue.response) {
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
    

}
