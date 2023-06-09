package com.mysql.example.demo.responses.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerByTeamMobileResponse {
    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("position")
    public String position;

    @JsonProperty("status")
    public String status;

    @JsonProperty("playerID")
    public int playerID;

    @JsonProperty("teamID")
    public int teamID;

}
