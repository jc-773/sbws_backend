package com.mysql.example.demo.responses.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GamesByDateMobileResponse {

    @JsonProperty("gameID")
    public int gameID;

    @JsonProperty("status")
    public String status;

    @JsonProperty("dateTime")
    public String dateTime;

    @JsonProperty("awayTeam")
    public String awayTeam;

    @JsonProperty("homeTeam")
    public String homeTeam;

    @JsonProperty("awayTeamID")
    public int awayTeamID;

    @JsonProperty("homeTeamID")
    public int homeTeamID;

    @JsonProperty("stadiumID")
    public int stadiumID;

    @JsonProperty("awayTeamScore")
    public int awayTeamScore;

    @JsonProperty("homeTeamScore")
    public int homeTeamScore;

    @JsonProperty("updated")
    public String updated;

    @JsonProperty("neutralVenue")
    public boolean neutralVenue;

    @JsonProperty("dateTimeUTC")
    public String dateTimeUTC;

}
