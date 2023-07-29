package com.mysql.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mysql.example.demo.responses.mobile.PlayerByTeamMobileResponse;

public interface AllPlayersOnAllTeamsRepository extends MongoRepository<PlayerByTeamMobileResponse, String> {
    
    @Query("db.playerByTeamMobileResponse.distinct('playerID')")
    List<String> returnAllPlayerIds();
}
