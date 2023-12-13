package com.project.sbws.backend.services.backendExternalRequestServices.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestHeader;

import com.project.sbws.backend.responses.GamesByDate;
import com.project.sbws.backend.responses.PlayerByTeamResponse;
import com.project.sbws.backend.responses.PlayerProjectionResponse;
import com.project.sbws.backend.responses.PlayerResponse;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.responses.containers.AllTeamsContainer;



public interface IBackendRequestService {
    public List<PlayerResponse> PlayerInformation_Get(@RequestHeader String key);
    public Map<String, PlayerProjectionResponse> PlayerProjection_Get(String key, String playerId, String date);
    public List< PlayerProjectionResponse> PlayerProjectionByDate_Get(String key, String date);
    public List<PlayerByTeamResponse> PlayerByTeamResponse_Get(String key, String team);
    public List<GamesByDate> GamesByDate_Get( String date, String key);
    public Map<String, PlayerStatsNBADotCom> PlayerCareerStats(String playerID);
    public List<AllTeamsContainer> AllNBATeams_Get();
}
