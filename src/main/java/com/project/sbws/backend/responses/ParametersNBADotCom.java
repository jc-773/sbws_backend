package com.project.sbws.backend.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParametersNBADotCom {
    @JsonProperty("PerMode")
    public String perMode;

    @JsonProperty("PlusMinus")
    public String plusMinus;

    @JsonProperty("PaceAdjust")
    public String paceAdjust;

    @JsonProperty("Rank")
    public String rank;

    @JsonProperty("LeagueID")
    public String leagueID;

    @JsonProperty("Season")
    public String season;

    @JsonProperty("SeasonType")
    public String seasonType;

    @JsonProperty("PORound")
    public int pORound;

    @JsonProperty("PlayerID")
    public int playerID;

    @JsonProperty("Outcome")
    public String outcome;

    @JsonProperty("Location")
    public String location;

    @JsonProperty("Month")
    public int month;

    @JsonProperty("SeasonSegment")
    public String seasonSegment;

    @JsonProperty("DateFrom")
    public String dateFrom;

    @JsonProperty("DateTo")
    public String dateTo;

    @JsonProperty("OpponentTeamID")
    public int opponentTeamID;

    @JsonProperty("VsConference")
    public String vsConference;

    @JsonProperty("VsDivision")
    public String vsDivision;

    @JsonProperty("GameSegment")
    public String gameSegment;

    @JsonProperty("Period")
    public int period;

    @JsonProperty("ShotClockRange")
    public String shotClockRange;

    @JsonProperty("LastNGames")
    public int lastNGames;

    @JsonProperty("ISTRound")
    public int istRound;

}
