package com.project.sbws.backend.responses.containers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;

public class PlayerStatsNBADotComContainer {
    @JsonProperty("key")
    public List<PlayerStatsNBADotCom> response;
}
