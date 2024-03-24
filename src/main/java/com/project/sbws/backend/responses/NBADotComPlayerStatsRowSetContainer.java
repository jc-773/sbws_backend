package com.project.sbws.backend.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NBADotComPlayerStatsRowSetContainer {
    
     @JsonProperty("headers")
    public List<String> headers;
}
