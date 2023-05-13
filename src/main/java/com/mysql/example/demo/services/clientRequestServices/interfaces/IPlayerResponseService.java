package com.mysql.example.demo.services.clientRequestServices.interfaces;

import org.springframework.http.ResponseEntity;

import com.mysql.example.demo.Player;
import com.mysql.example.demo.responses.PlayerResponse;

public interface IPlayerResponseService {
    
    public ResponseEntity<PlayerResponse> returnPlayerResponse(Player player);
}
