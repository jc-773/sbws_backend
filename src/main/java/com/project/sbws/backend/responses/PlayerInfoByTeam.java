package com.project.sbws.backend.responses;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerInfoByTeam {
     @JsonProperty("PlayerID")
    private int playerID;

    @JsonProperty("SportsDataID")
    private String sportsDataID;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("TeamID")
    private int teamID;

    @JsonProperty("Team")
    private String team;

    @JsonProperty("Jersey")
    private int jersey;

    @JsonProperty("PositionCategory")
    private String positionCategory;

    @JsonProperty("Position")
    private String position;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Height")
    private int height;

    @JsonProperty("Weight")
    private int weight;

    @JsonProperty("BirthDate")
    private Date birthDate;

    @JsonProperty("BirthCity")
    private String birthCity;

    @JsonProperty("BirthCountry")
    private String birthCountry;

    @JsonProperty("College")
    private String college;

    @JsonProperty("Salary")
    private int salary;

    @JsonProperty("PhotoUrl")
    private String photoUrl;

    @JsonProperty("Experience")
    private int experience;

    @JsonProperty("SportRadarPlayerID")
    private String sportRadarPlayerID;

    @JsonProperty("RotoworldPlayerID")
    private int rotoworldPlayerID;

    @JsonProperty("RotoWirePlayerID")
    private int rotoWirePlayerID;

    @JsonProperty("FantasyAlarmPlayerID")
    private int fantasyAlarmPlayerID;

    @JsonProperty("StatsPlayerID")
    private int statsPlayerID;

    @JsonProperty("SportsDirectPlayerID")
    private int sportsDirectPlayerID;

    @JsonProperty("XmlTeamPlayerID")
    private int xmlTeamPlayerID;

    @JsonProperty("InjuryStatus")
    private String injuryStatus;

    @JsonProperty("InjuryBodyPart")
    private String injuryBodyPart;

    @JsonProperty("InjuryStartDate")
    private Date injuryStartDate;

    @JsonProperty("InjuryNotes")
    private String injuryNotes;

    @JsonProperty("FanDuelPlayerID")
    private int fanDuelPlayerID;

    @JsonProperty("DraftKingsPlayerID")
    private int draftKingsPlayerID;

    @JsonProperty("YahooPlayerID")
    private int yahooPlayerID;

    @JsonProperty("FanDuelName")
    private String fanDuelName;

    @JsonProperty("DraftKingsName")
    private String draftKingsName;

    @JsonProperty("YahooName")
    private String yahooName;

    @JsonProperty("DepthChartPosition")
    private String depthChartPosition;

    @JsonProperty("DepthChartOrder")
    private int depthChartOrder;

    @JsonProperty("GlobalTeamID")
    private int globalTeamID;

    @JsonProperty("FantasyDraftName")
    private String fantasyDraftName;

    @JsonProperty("FantasyDraftPlayerID")
    private int fantasyDraftPlayerID;

    @JsonProperty("UsaTodayPlayerID")
    private int usaTodayPlayerID;

    @JsonProperty("UsaTodayHeadshotUrl")
    private String usaTodayHeadshotUrl;

    @JsonProperty("UsaTodayHeadshotNoBackgroundUrl")
    private String usaTodayHeadshotNoBackgroundUrl;

    @JsonProperty("UsaTodayHeadshotUpdated")
    private Date usaTodayHeadshotUpdated;

    @JsonProperty("UsaTodayHeadshotNoBackgroundUpdated")
    private Date usaTodayHeadshotNoBackgroundUpdated;

    @JsonProperty("NbaDotComPlayerID")
    private int nbaDotComPlayerID;
}
