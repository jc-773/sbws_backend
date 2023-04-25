package com.mysql.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mysql.example.demo.responses.PlayerByTeamResponse;

public interface TeamsRepository extends MongoRepository<PlayerByTeamResponse, String> {
  
}
