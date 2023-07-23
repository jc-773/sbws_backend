package com.mysql.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mysql.example.demo.responses.mobile.PlayerByTeamMobileResponse;

public interface AllPlayersOnAllTeamsRepository extends MongoRepository<PlayerByTeamMobileResponse, String> {
    
}
