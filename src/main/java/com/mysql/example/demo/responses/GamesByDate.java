package com.mysql.example.demo.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GamesByDate {
    @JsonProperty("GameEndDateTime")
    public String gameEndDateTime;

    @JsonProperty("GameID")
    public int gameID;

    @JsonProperty("Season")
    public int season;

    @JsonProperty("SeasonType")
    public int seasonType;

    @JsonProperty("Status")
    public String status;

    @JsonProperty("Day")
    public String day;

    @JsonProperty("DateTime")
    public String dateTime;

    @JsonProperty("AwayTeam")
    public String awayTeam;

    @JsonProperty("HomeTeam")
    public String homeTeam;

    @JsonProperty("AwayTeamID")
    public int awayTeamID;

    @JsonProperty("HomeTeamID")
    public int homeTeamID;

    @JsonProperty("StadiumID")
    public int stadiumID;

    @JsonProperty("AwayTeamScore")
    public int awayTeamScore;

    @JsonProperty("HomeTeamScore")
    public int homeTeamScore;

    @JsonProperty("Updated")
    public String updated;

    @JsonProperty("GlobalGameID")
    public int globalGameID;

    @JsonProperty("GlobalAwayTeamID")
    public int globalAwayTeamID;

    @JsonProperty("GlobalHomeTeamID")
    public int globalHomeTeamID;

    @JsonProperty("IsClosed")
    public boolean isClosed;

    @JsonProperty("NeutralVenue")
    public boolean neutralVenue;

    @JsonProperty("DateTimeUTC")
    public String dateTimeUTC;

    @JsonProperty("SeriesInfo")
    public SeriesInfo seriesInfo;

}
