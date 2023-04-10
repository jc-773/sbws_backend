package com.mysql.example.demo.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.example.demo.responses.containers.PlayerResponseContainer;

public class PlayerResponse {
    
    @JsonProperty("key")
    public List<PlayerResponseContainer> response;
    
}
