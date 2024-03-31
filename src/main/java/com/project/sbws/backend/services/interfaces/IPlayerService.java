package com.project.sbws.backend.services.interfaces;

import java.util.Map;

import com.project.sbws.backend.responses.PlayerStatsNBADotCom;



public interface IPlayerService {
   
    public void saveOverallBasePlayerDashboardFromNBADotCom(Integer playerID, Map<String, PlayerStatsNBADotCom> playerStat);
    //public ResponseEntity<PlayerProfileResponse> returnPlayerProfile(List<PlayerResponse> playerResponse, String playerFirstName, String playerLastName, PlayerProjectionResponse playerProjectionResponse);
    //public String getPlayerIdForProjectiions(List<PlayerResponse> playerResponse,  String playerFirstName, String playerLastName);

}
