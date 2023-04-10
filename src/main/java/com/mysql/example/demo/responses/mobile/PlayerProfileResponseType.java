package com.mysql.example.demo.responses.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerProfileResponseType {
    @JsonProperty("playerID")
    public String playerID;

    @JsonProperty("status")
    public String status;

    @JsonProperty("team")
    public String team;

    @JsonProperty("position")
    public String position;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("projectedThreesMade")
    public Double projectedThreesMade;

    @JsonProperty("projectedRebounds")
    public Double projectedRebounds;

    @JsonProperty("projectedAssists")
    public Double projectedAssists;

    @JsonProperty("projectedPoints")
    public Double projectedPoints;
}
