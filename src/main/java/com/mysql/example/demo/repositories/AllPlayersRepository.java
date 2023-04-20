package com.mysql.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mysql.example.demo.responses.PlayerResponse;

public interface AllPlayersRepository extends MongoRepository<List<PlayerResponse>, String>{
    
}
