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

    @JsonProperty("Team")
    public String team;

    @JsonProperty("SportRadarPlayerID")
    public String sportRadarPlayerID;

    @JsonProperty("RotoworldPlayerID")
    public int rotoworldPlayerID;

    @JsonProperty("RotoWirePlayerID")
    public int rotoWirePlayerID;

    @JsonProperty("FantasyAlarmPlayerID")
    public int fantasyAlarmPlayerID;

    @JsonProperty("StatsPlayerID")
    public int statsPlayerID;

    @JsonProperty("SportsDirectPlayerID")
    public int sportsDirectPlayerID;

    @JsonProperty("XmlTeamPlayerID")
    public int xmlTeamPlayerID;

    @JsonProperty("FanDuelPlayerID")
    public int fanDuelPlayerID;

    @JsonProperty("DraftKingsPlayerID")
    public int draftKingsPlayerID;

    @JsonProperty("YahooPlayerID")
    public int yahooPlayerID;

    @JsonProperty("FanDuelName")
    public String fanDuelName;

    @JsonProperty("DraftKingsName")
    public String draftKingsName;

    @JsonProperty("YahooName")
    public String yahooName;

    @JsonProperty("NbaDotComPlayerID")
    public int nbaDotComPlayerID;

}
