package com.mysql.example.demo.services.clientRequestServices.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.mysql.example.demo.responses.PlayerByTeamResponse;
import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerStatsNBADotCom;
import com.mysql.example.demo.responses.ResultStatsNBADotCom;
import com.mysql.example.demo.responses.mobile.PlayerByTeamMobileResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponse;

public interface IPlayerService {
    public ResponseEntity<PlayerProfileResponse> returnPlayerProfileFromBackend(String playerID, PlayerProjectionResponse playerProjectionResponse, Map<String, PlayerStatsNBADotCom> playerStats );
    public ResponseEntity<List<PlayerByTeamMobileResponse>> returnPlayerRosterByTeam(List<PlayerByTeamResponse> roster); 
    //public ResponseEntity<PlayerProfileResponse> returnPlayerProfile(List<PlayerResponse> playerResponse, String playerFirstName, String playerLastName, PlayerProjectionResponse playerProjectionResponse);
    //public String getPlayerIdForProjectiions(List<PlayerResponse> playerResponse,  String playerFirstName, String playerLastName);

}
