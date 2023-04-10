package com.mysql.example.demo;

import org.springframework.http.ResponseEntity;

import com.mysql.example.demo.responses.PlayerResponse;

public interface IPlayerResponseService {
    
    public ResponseEntity<PlayerResponse> returnPlayerResponse(Player player);
}
