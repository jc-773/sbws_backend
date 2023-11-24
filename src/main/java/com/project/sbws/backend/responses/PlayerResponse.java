package com.project.sbws.backend.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.sbws.backend.responses.containers.PlayerResponseContainer;



public class PlayerResponse {
    
    @JsonProperty("key")
    public List<PlayerResponseContainer> response;
    
}
