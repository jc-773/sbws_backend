package com.mysql.example.demo.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeriesInfo {
    @JsonProperty("HomeTeamWins")
    public int homeTeamWins;

    @JsonProperty("AwayTeamWins")
    public int awayTeamWins;

    @JsonProperty("GameNumber")
    public int gameNumber;

    @JsonProperty("MaxLength")
    public int maxLength;
}
