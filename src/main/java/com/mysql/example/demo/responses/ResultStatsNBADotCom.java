package com.mysql.example.demo.responses;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultStatsNBADotCom {
    
    @JsonProperty("name")
    public String name;

    @JsonProperty("headers")
    public ArrayList<String> headers;

    @JsonProperty("rowSet")
    public ArrayList<Object> rowSet;

}
