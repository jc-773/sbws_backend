package com.mysql.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mysql.example.demo.responses.PlayerByTeamResponse;
import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.mobile.PlayerByTeamMobileResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponse;

public interface IPlayerService {
    public ResponseEntity<PlayerProfileResponse> returnPlayerProfileFromBackend(String playerID, PlayerProjectionResponse playerProjectionResponse);
    public ResponseEntity<List<PlayerByTeamMobileResponse>> returnPlayerRosterByTeam(List<PlayerByTeamResponse> roster); 
    //public ResponseEntity<PlayerProfileResponse> returnPlayerProfile(List<PlayerResponse> playerResponse, String playerFirstName, String playerLastName, PlayerProjectionResponse playerProjectionResponse);
    //public String getPlayerIdForProjectiions(List<PlayerResponse> playerResponse,  String playerFirstName, String playerLastName);

}
