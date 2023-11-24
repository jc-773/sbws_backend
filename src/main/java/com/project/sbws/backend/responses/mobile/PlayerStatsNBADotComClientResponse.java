package com.project.sbws.backend.responses.mobile;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerStatsNBADotComClientResponse {
    @Id
    @JsonProperty("playerID")
    public String playerID;

    @JsonProperty("rebounds")
    public double rebounds;

    @JsonProperty("assists")
    public Integer assists;

    @JsonProperty("steals")
    public double steals;
}
