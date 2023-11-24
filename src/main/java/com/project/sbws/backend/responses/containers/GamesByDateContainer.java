package com.project.sbws.backend.responses.containers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.sbws.backend.responses.GamesByDate;



public class GamesByDateContainer {
    @JsonProperty("key")
    public List<GamesByDate> response;
}
