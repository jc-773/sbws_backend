package com.project.sbws.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.sbws.backend.responses.PlayerByTeamResponse;


public interface TeamsRepository extends MongoRepository<PlayerByTeamResponse, String> {
  
}
