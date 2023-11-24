package com.project.sbws.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.sbws.backend.responses.mobile.PlayerByTeamMobileResponse;


public interface AllPlayersOnAllTeamsRepository extends MongoRepository<PlayerByTeamMobileResponse, Integer> {
    
    @Query("{nbaDotComPlayerID: ?0}")
    PlayerByTeamMobileResponse findPlayerByNBADotComPlayerId(int playerID);
}
