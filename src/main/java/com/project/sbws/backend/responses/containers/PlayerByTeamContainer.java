package com.project.sbws.backend.responses.containers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.sbws.backend.responses.PlayerByTeamResponse;


public class PlayerByTeamContainer {
    @JsonProperty("key")
    public List<PlayerByTeamResponse> response;
}
