package com.project.sbws.backend.responses.containers;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.sbws.backend.responses.AllTeamsResponse;


public class AllTeamsContainer {
    @JsonProperty("response")
    public Map<String, AllTeamsResponse> response;
}
