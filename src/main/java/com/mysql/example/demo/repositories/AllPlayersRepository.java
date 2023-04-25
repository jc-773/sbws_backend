package com.mysql.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mysql.example.demo.responses.containers.PlayerResponseContainer;

public interface AllPlayersRepository extends MongoRepository<PlayerResponseContainer, String>{
    @Query("{playerID:'?0'}")
    PlayerResponseContainer findPlayerByPlayerId(String playerID);
}
