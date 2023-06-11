package com.mysql.example.demo.responses;

import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultSets {
    @JsonProperty("name")
    public String name;

    @JsonProperty("headers")
    public ArrayList<String> headers;

    @JsonProperty("rowSet")
    public ArrayList<Object> rowSet;

    
}
