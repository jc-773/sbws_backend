package com.mysql.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mysql.example.demo.responses.mobile.PlayerProfileResponseType;

public interface PlayerProfileRepository extends MongoRepository<PlayerProfileResponseType, String>  {
    @Query("{firstName:'?0'}")
    PlayerProfileResponseType findItemByName(String name);
    
    @Query(value="{team:'?0'}", fields="{'firstName' : 1, 'lastName' : 1}")
    List<PlayerProfileResponseType> findAll(String category);

}
