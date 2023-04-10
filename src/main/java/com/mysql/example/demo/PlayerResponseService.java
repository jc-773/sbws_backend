package com.mysql.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mysql.example.demo.responses.PlayerResponse;

@Service
public class PlayerResponseService implements IPlayerResponseService {

    @Override
    public ResponseEntity<PlayerResponse> returnPlayerResponse(Player player) {
       try {
        player.name = "Folksnem";
        return new ResponseEntity<PlayerResponse>(HttpStatus.OK);
       } catch (Exception e) {
        // TODO: handle exception
       }
        return null;
    }
    
}
