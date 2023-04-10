package com.mysql.example.demo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface TestRepository extends CrudRepository<Player, Long>{
    
}
