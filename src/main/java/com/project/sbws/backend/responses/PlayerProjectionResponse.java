package com.project.sbws.backend.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerProjectionResponse {
    @JsonProperty("StatID")
    public Integer statID;

    @JsonProperty("TeamID")
    public Integer teamID;

    @JsonProperty("PlayerID")
    public Integer playerID;

    @JsonProperty("SeasonType")
    public Integer seasonType;

    @JsonProperty("Season")
    public Integer season;

    @JsonProperty("Name")
    public String name;

    @JsonProperty("Team")
    public String team;

    @JsonProperty("Position")
    public String position;

    @JsonProperty("Started")
    public Integer started;

    @JsonProperty("FanDuelSalary")
    public Integer fanDuelSalary;

    @JsonProperty("DraftKingsSalary")
    public Integer draftKingsSalary;

    @JsonProperty("FantasyDataSalary")
    public Integer fantasyDataSalary;

    @JsonProperty("YahooSalary")
    public Integer yahooSalary;

    @JsonProperty("InjuryStatus")
    public String injuryStatus;

    @JsonProperty("InjuryBodyPart")
    public String injuryBodyPart;

    @JsonProperty("InjuryStartDate")
    public String injuryStartDate;

    @JsonProperty("InjuryNotes")
    public String injuryNotes;

    @JsonProperty("FanDuelPosition")
    public String fanDuelPosition;

    @JsonProperty("DraftKingsPosition")
    public String draftKingsPosition;

    @JsonProperty("YahooPosition")
    public String yahooPosition;

    @JsonProperty("OpponentRank")
    public Integer opponentRank;

    @JsonProperty("OpponentPositionRank")
    public Integer opponentPositionRank;

    @JsonProperty("GlobalTeamID")
    public Integer globalTeamID;

    @JsonProperty("FantasyDraftSalary")
    public Object fantasyDraftSalary;

    @JsonProperty("FantasyDraftPosition")
    public String fantasyDraftPosition;

    @JsonProperty("GameID")
    public Integer gameID;

    @JsonProperty("OpponentID")
    public Integer opponentID;

    @JsonProperty("Opponent")
    public String opponent;

    @JsonProperty("Day")
    public String day;

    @JsonProperty("DateTime")
    public String dateTime;

    @JsonProperty("HomeOrAway")
    public String homeOrAway;

    @JsonProperty("IsGameOver")
    public Boolean isGameOver;

    @JsonProperty("GlobalGameID")
    public Integer globalGameID;

    @JsonProperty("GlobalOpponentID")
    public Integer globalOpponentID;

    @JsonProperty("Updated")
    public String updated;

    @JsonProperty("Games")
    public Integer games;

    @JsonProperty("FantasyPoints")
    public Double fantasyPoints;

    @JsonProperty("Minutes")
    public Integer minutes;

    @JsonProperty("Seconds")
    public Integer seconds;

    @JsonProperty("FieldGoalsMade")
    public Double fieldGoalsMade;

    @JsonProperty("FieldGoalsAttempted")
    public Double fieldGoalsAttempted;

    @JsonProperty("FieldGoalsPercentage")
    public Double fieldGoalsPercentage;

    @JsonProperty("EffectiveFieldGoalsPercentage")
    public Double effectiveFieldGoalsPercentage;

    @JsonProperty("TwoPointersMade")
    public Double twoPointersMade;

    @JsonProperty("TwoPointersAttempted")
    public Double twoPointersAttempted;

    @JsonProperty("TwoPointersPercentage")
    public Double twoPointersPercentage;

    @JsonProperty("ThreePointersMade")
    public Double threePointersMade;

    @JsonProperty("ThreePointersAttempted")
    public Double threePointersAttempted;

    @JsonProperty("ThreePointersPercentage")
    public Double threePointersPercentage;

    @JsonProperty("FreeThrowsMade")
    public Double freeThrowsMade;

    @JsonProperty("FreeThrowsAttempted")
    public Double freeThrowsAttempted;

    @JsonProperty("FreeThrowsPercentage")
    public Double freeThrowsPercentage;

    @JsonProperty("OffensiveRebounds")
    public Double offensiveRebounds;

    @JsonProperty("DefensiveRebounds")
    public Double defensiveRebounds;

    @JsonProperty("Rebounds")
    public Double rebounds;

    @JsonProperty("OffensiveReboundsPercentage")
    public Object offensiveReboundsPercentage;

    @JsonProperty("DefensiveReboundsPercentage")
    public Object defensiveReboundsPercentage;

    @JsonProperty("TotalReboundsPercentage")
    public Object totalReboundsPercentage;

    @JsonProperty("Assists")
    public Double assists;

    @JsonProperty("Steals")
    public Double steals;

    @JsonProperty("BlockedShots")
    public Double blockedShots;

    @JsonProperty("Turnovers")
    public Double turnovers;

    @JsonProperty("PersonalFouls")
    public Double personalFouls;

    @JsonProperty("Points")
    public Double points;

    @JsonProperty("TrueShootingAttempts")
    public Double trueShootingAttempts;

    @JsonProperty("TrueShootingPercentage")
    public Double trueShootingPercentage;

    @JsonProperty("PlayerEfficiencyRating")
    public Object playerEfficiencyRating;

    @JsonProperty("AssistsPercentage")
    public Object assistsPercentage;

    @JsonProperty("StealsPercentage")
    public Object stealsPercentage;

    @JsonProperty("BlocksPercentage")
    public Object blocksPercentage;

    @JsonProperty("TurnOversPercentage")
    public Object turnOversPercentage;

    @JsonProperty("UsageRatePercentage")
    public Object usageRatePercentage;

    @JsonProperty("FantasyPointsFanDuel")
    public Double fantasyPointsFanDuel;

    @JsonProperty("FantasyPointsDraftKings")
    public Double fantasyPointsDraftKings;

    @JsonProperty("FantasyPointsYahoo")
    public Double fantasyPointsYahoo;

    @JsonProperty("PlusMinus")
    public Double plusMinus;

    @JsonProperty("DoubleDoubles")
    public Double doubleDoubles;

    @JsonProperty("TripleDoubles")
    public Double tripleDoubles;

    @JsonProperty("FantasyPointsFantasyDraft")
    public Double fantasyPointsFantasyDraft;

    @JsonProperty("IsClosed")
    public Boolean isClosed;

    @JsonProperty("LineupConfirmed")
    public Boolean lineupConfirmed;

    @JsonProperty("LineupStatus") 
    public String lineupStatus;
}
