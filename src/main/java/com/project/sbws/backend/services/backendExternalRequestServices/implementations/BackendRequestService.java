package com.project.sbws.backend.services.backendExternalRequestServices.implementations;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbws.backend.responses.GamesByDate;
import com.project.sbws.backend.responses.PlayerByTeamResponse;
import com.project.sbws.backend.responses.PlayerProjectionResponse;
import com.project.sbws.backend.responses.PlayerResponse;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.responses.containers.AllTeamsContainer;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IAllNBATeamsRequestService;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IBackendRequestService;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IGamesByDateRequestService;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.INBAPlayerRequestService;



@Service
public class BackendRequestService implements IBackendRequestService {
    
    @Autowired
    INBAPlayerRequestService nbaPlayerRequests;

    @Autowired
    IGamesByDateRequestService gamesByDateRequestService;

    @Autowired
    IAllNBATeamsRequestService allNBAteamsRequestService;

    // Player Services
    @Override
    public List<PlayerResponse> PlayerInformation_Get(String key) {
        return (List<PlayerResponse>) nbaPlayerRequests.PlayerResponse_Get(PlayerResponse.class, key);
    }

    @Override
    public  Map<String, PlayerProjectionResponse> PlayerProjection_Get(String key, String playerId, String date) {
       
        return ( Map<String, PlayerProjectionResponse>) nbaPlayerRequests.PlayerProjection_Get(PlayerProjectionResponse.class, key,
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

    @Override
    public List<AllTeamsContainer> AllNBATeams_Get() {
      return (List<AllTeamsContainer>) allNBAteamsRequestService.AllTeams_Get(AllTeamsContainer.class);
    }
    
}
