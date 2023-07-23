package com.mysql.example.demo.responses.containers;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.example.demo.responses.AllTeamsResponse;

public class AllTeamsContainer {
    @JsonProperty("response")
    public Map<String, AllTeamsResponse> response;
}
