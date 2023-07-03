package com.mysql.example.demo.services.backendExternalRequestServices.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.mysql.example.demo.responses.GamesByDate;
import com.mysql.example.demo.responses.PlayerByTeamResponse;
import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.PlayerStatsNBADotCom;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IBackendRequestService;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IGamesByDateRequestService;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.INBAPlayerRequestService;

@Service
public class BackendRequestService implements IBackendRequestService {

    private final INBAPlayerRequestService nbaPlayerRequests;
    private final IGamesByDateRequestService gamesByDateRequestService;

    @Autowired
    public BackendRequestService(INBAPlayerRequestService nbaPlayerRequests, IGamesByDateRequestService gamesByDateRequestService) {
        this.nbaPlayerRequests = nbaPlayerRequests;
        this.gamesByDateRequestService = gamesByDateRequestService;
    }

    // Player Services
    @Override
    public List<PlayerResponse> PlayerInformation_Get(String key) {
        return (List<PlayerResponse>) nbaPlayerRequests.PlayerResponse_Get(PlayerResponse.class, key);
    }

    @Override
    public PlayerProjectionResponse PlayerProjection_Get(String key, String playerId, String date) {
       
        return (PlayerProjectionResponse) nbaPlayerRequests.PlayerProjection_Get(PlayerProjectionResponse.class, key,
        playerId, date);
    }

    @Override
    public List<PlayerByTeamResponse> PlayerByTeamResponse_Get(String key, String team) {
        return (List<PlayerByTeamResponse>) nbaPlayerRequests.PlayerByTeamResponse_Get(PlayerByTeamResponse.class, key,
        team);
    }

    //Games Services
    @Override
    public List<GamesByDate> GamesByDate_Get(String date, String key) {
       return (List<GamesByDate>) gamesByDateRequestService.GamesByDateResponse_Get(GamesByDate.class, date, key);
    }

    @Override
    public  Map<String, PlayerStatsNBADotCom> PlayerCareerStats(String playerID) {
       
       return ( Map<String, PlayerStatsNBADotCom>) nbaPlayerRequests.PlayerCareerStats(PlayerStatsNBADotCom.class, playerID); 
    }
    
}
