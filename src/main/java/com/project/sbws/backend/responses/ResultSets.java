package com.project.sbws.backend.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultSets {
    @JsonProperty("name")
    public String name;

    @JsonProperty("headers")
    public List<String> headers;

    @JsonProperty("rowSet")
    public List<List<Object>> rowSet;
}


