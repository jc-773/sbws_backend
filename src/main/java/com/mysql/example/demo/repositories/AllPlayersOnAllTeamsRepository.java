package com.mysql.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mysql.example.demo.responses.mobile.PlayerByTeamMobileResponse;

public interface AllPlayersOnAllTeamsRepository extends MongoRepository<PlayerByTeamMobileResponse, Integer> {
    
    @Query("{nbaDotComPlayerID: ?0}")
    PlayerByTeamMobileResponse findPlayerByNBADotComPlayerId(int playerID);
}
