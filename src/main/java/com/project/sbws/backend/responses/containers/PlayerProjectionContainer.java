package com.project.sbws.backend.responses.containers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.sbws.backend.responses.PlayerProjectionResponse;

public class PlayerProjectionContainer {
    @JsonProperty("key")
    public List<PlayerProjectionResponse> response;
}
