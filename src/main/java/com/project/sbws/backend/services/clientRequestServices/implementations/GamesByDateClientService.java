package com.project.sbws.backend.services.clientRequestServices.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sbws.backend.responses.GamesByDate;
import com.project.sbws.backend.responses.containers.GamesByDateContainer;
import com.project.sbws.backend.responses.mobile.GamesByDateMobileResponse;
import com.project.sbws.backend.services.clientRequestServices.interfaces.IGamesByDateClientService;

@Service
public class GamesByDateClientService implements IGamesByDateClientService{

    @Override //Games By Date Controller
    public ResponseEntity<List<GamesByDateMobileResponse>> returnGamesByDate(List<GamesByDate> gamesByDateResponse) {
        try {
            Map<String, List<GamesByDate>> gamesByDateMap = new HashMap<>();
            gamesByDateMap.put("key", gamesByDateResponse);
            String jsonString = new ObjectMapper().writeValueAsString(gamesByDateMap);
            ObjectMapper mapper = new ObjectMapper();
            GamesByDateContainer readValue = mapper.readValue(jsonString, GamesByDateContainer.class);
            List<GamesByDateMobileResponse> gamesByDateMobileList = new ArrayList<>();
            for(GamesByDate games : readValue.response) {
                GamesByDateMobileResponse gamesByDateMobileResponse = new GamesByDateMobileResponse();
                gamesByDateMobileResponse.gameID = games.gameID;
                gamesByDateMobileResponse.status = games.status;
                gamesByDateMobileResponse.dateTime = games.dateTime;
                gamesByDateMobileResponse.homeTeam = games.homeTeam;
                gamesByDateMobileResponse.awayTeam = games.awayTeam;
                gamesByDateMobileResponse.stadiumID = games.stadiumID;
                gamesByDateMobileResponse.awayTeamScore = games.awayTeamScore;
                gamesByDateMobileResponse.homeTeamScore = games.homeTeamScore;
                gamesByDateMobileResponse.updated = games.updated;
                gamesByDateMobileResponse.neutralVenue = games.neutralVenue;
                gamesByDateMobileResponse.dateTimeUTC = games.dateTimeUTC;
                gamesByDateMobileList.add(gamesByDateMobileResponse);
            }
            
            return new ResponseEntity<List<GamesByDateMobileResponse>>(gamesByDateMobileList, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

   
    
}
