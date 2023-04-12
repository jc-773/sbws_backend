package com.mysql.example.demo.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerByTeamResponse {
    @JsonProperty("PlayerID")
    public int playerID;

    @JsonProperty("SportsDataID")
    public String sportsDataID;

    @JsonProperty("Status")
    public String status;

    @JsonProperty("TeamID")
    public int teamID;

    @JsonProperty("Team")
    public String team;

    @JsonProperty("Jersey")
    public int jersey;

    @JsonProperty("PositionCategory")
    public String positionCategory;

    @JsonProperty("Position")
    public String position;

    @JsonProperty("FirstName")
    public String firstName;

    @JsonProperty("LastName")
    public String lastName;

    @JsonProperty("Height")
    public int height;

    @JsonProperty("Weight")
    public int weight;

    @JsonProperty("BirthDate")
    public String birthDate;

    @JsonProperty("BirthCity")
    public String birthCity;

    @JsonProperty("BirthState")
    public String birthState;

    @JsonProperty("BirthCountry")
    public String birthCountry;

    @JsonProperty("HighSchool")
    public String highSchool;

    @JsonProperty("College")
    public String college;

    @JsonProperty("Salary")
    public int salary;

    @JsonProperty("PhotoUrl")
    public String photoUrl;

    @JsonProperty("Experience")
    public int experience;

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

    @JsonProperty("InjuryStatus")
    public String injuryStatus;

    @JsonProperty("InjuryBodyPart")
    public String injuryBodyPart;

    @JsonProperty("InjuryStartDate")
    public String injuryStartDate;

    @JsonProperty("InjuryNotes")
    public String injuryNotes;

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

    @JsonProperty("DepthChartPosition")
    public String depthChartPosition;

    @JsonProperty("DepthChartOrder")
    public int depthChartOrder;

    @JsonProperty("GlobalTeamID")
    public int globalTeamID;

    @JsonProperty("FantasyDraftName")
    public String fantasyDraftName;

    @JsonProperty("FantasyDraftPlayerID")
    public int fantasyDraftPlayerID;

    @JsonProperty("UsaTodayPlayerID")
    public int usaTodayPlayerID;

    @JsonProperty("UsaTodayHeadshotUrl")
    public String usaTodayHeadshotUrl;

    @JsonProperty("UsaTodayHeadshotNoBackgroundUrl")
    public String usaTodayHeadshotNoBackgroundUrl;

    @JsonProperty("UsaTodayHeadshotUpdated")
    public String usaTodayHeadshotUpdated;

    @JsonProperty("UsaTodayHeadshotNoBackgroundUpdated")
    public String usaTodayHeadshotNoBackgroundUpdated;

    @JsonProperty("NbaDotComPlayerID")
    public int nbaDotComPlayerID;

}
