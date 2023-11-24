package com.project.sbws.backend.responses;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.sbws.backend.responses.database.PlayerStatsNBADotComDocument;


public class ResultStatsNBADotCom {
    
    @JsonProperty("name")
    public String name;

    @JsonProperty("headers")
    public ArrayList<String> headers;

    @JsonProperty("rowSet")
    public ArrayList<PlayerStatsNBADotComDocument> rowSet;

}
