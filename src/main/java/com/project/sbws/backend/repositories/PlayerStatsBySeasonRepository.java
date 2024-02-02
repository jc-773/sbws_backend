package com.project.sbws.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.sbws.backend.responses.database.PlayerStatsNBADotComDocument;

public interface PlayerStatsBySeasonRepository extends MongoRepository<PlayerStatsNBADotComDocument, String>{

    @Query("{firstName:'?0'}")
    PlayerStatsNBADotComDocument getPlayerStatsByYearWithPlayerID(String playerID);
    
} 