package com.mysql.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponse;

public interface IPlayerService {
    public Player savePlayer( List<PlayerResponse> playerResponse);
    public String getPlayerIdForProjectiions(List<PlayerResponse> playerResponse,  String playerFirstName, String playerLastName);
    public ResponseEntity<PlayerProfileResponse> returnPlayerProfile(List<PlayerResponse> playerResponse, String playerFirstName, String playerLastName, PlayerProjectionResponse playerProjectionResponse);
}
