package com.mysql.example.demo.responses;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultSets {
    @JsonProperty("name")
    public String name;

    @JsonProperty("headers")
    ArrayList<String> headers;

    @JsonProperty("rowSet")
    ArrayList<Object> rowSet;
}
