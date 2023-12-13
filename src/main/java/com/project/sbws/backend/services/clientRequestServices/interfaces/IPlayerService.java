package com.project.sbws.backend.services.clientRequestServices.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.project.sbws.backend.responses.PlayerByTeamResponse;
import com.project.sbws.backend.responses.PlayerProjectionResponse;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.responses.mobile.PlayerByTeamMobileResponse;
import com.project.sbws.backend.responses.mobile.PlayerProfileResponse;


public interface IPlayerService {
    public ResponseEntity<PlayerProfileResponse> returnPlayerProfileFromBackend(String playerID,  List<PlayerProjectionResponse> playerProjectionResponse, Map<String, PlayerStatsNBADotCom> playerStats );
    public ResponseEntity<List<PlayerByTeamMobileResponse>> returnPlayerRosterByTeam(List<PlayerByTeamResponse> roster); 
    public void storeListOfPlayersOnTeam(List<PlayerByTeamResponse> roster);  
    public List<Integer> returnAllPlayerIds();
    public void saveOverallBasePlayerDashboardFromNBADotCom(Integer playerID, Map<String, PlayerStatsNBADotCom> playerStat);
    public void dropCollection(String collectionName);
    //public ResponseEntity<PlayerProfileResponse> returnPlayerProfile(List<PlayerResponse> playerResponse, String playerFirstName, String playerLastName, PlayerProjectionResponse playerProjectionResponse);
    //public String getPlayerIdForProjectiions(List<PlayerResponse> playerResponse,  String playerFirstName, String playerLastName);

}
