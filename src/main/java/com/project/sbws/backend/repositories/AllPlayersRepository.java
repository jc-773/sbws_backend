package com.project.sbws.backend.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.sbws.backend.responses.containers.PlayerResponseContainer;


public interface AllPlayersRepository extends MongoRepository<PlayerResponseContainer, String>{
    @Query("{playerID:'?0'}")
    PlayerResponseContainer findPlayerByPlayerId(String playerID);

    
}
