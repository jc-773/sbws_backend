package com.project.sbws.backend.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AllTeamsResponse {
    @JsonProperty("TeamID")
    public int teamID;

    @JsonProperty("Key")
    public String key;

    @JsonProperty("Active")
    public String active;

    @JsonProperty("City")
    public String city;

    @JsonProperty("Name")
    public String name;

    @JsonProperty("LeagueID")
    public String leagueID;

    @JsonProperty("StadiumID")
    public String stadiumID;

    @JsonProperty("Conference")
    public String conference;

    @JsonProperty("Division")
    public String division;

    @JsonProperty("PrimaryColor")
    public String primaryColor;

    @JsonProperty("SecondaryColor")
    public String secondaryColor;

    @JsonProperty("TertiaryColor")
    public String tertiaryColor;

    @JsonProperty("QuaternaryColor")
    public String quaternaryColor;

    @JsonProperty("WikipediaLogoUrl")
    public String wikipediaLogoUrl;

    @JsonProperty("WikipediaWordMarkUrl")
    public String wikipediaWordMarkUrl;

    @JsonProperty("GlobalTeamID")
    public String globalTeamID;

    @JsonProperty("NbaDotComTeamID")
    public String nbaDotComTeamID;

    @JsonProperty("HeadCoach")
    public String headCoach;

}
