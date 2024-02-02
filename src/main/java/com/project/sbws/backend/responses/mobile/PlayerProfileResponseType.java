package com.project.sbws.backend.responses.mobile;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document("playerProfile")
public class PlayerProfileResponseType {

    @Id
    @JsonProperty("playerID")
    public String playerID;

    @JsonProperty("status")
    public String status;

    @JsonProperty("team")
    public String team;

    @JsonProperty("position")
    public String position;

    @JsonProperty("projectedThreesMade")
    public Double projectedThreesMade;

    @JsonProperty("projectedRebounds")
    public Double projectedRebounds;

    @JsonProperty("projectedAssists")
    public Double projectedAssists;

    @JsonProperty("projectedPoints")
    public Double projectedPoints;

    @JsonProperty("name")
    public String name;

    @JsonProperty("minutes")
    public Integer minutes;

    @JsonProperty("seconds")
    public Integer seconds;

    @JsonProperty("fieldGoalsMade")
    public Double fieldGoalsMade;

    @JsonProperty("fieldGoalsAttempted")
    public Double fieldGoalsAttempted;

    @JsonProperty("fieldGoalsPercentage")
    public Double fieldGoalsPercentage;

    @JsonProperty("effectiveFieldGoalsPercentage")
    public Double effectiveFieldGoalsPercentage;

    @JsonProperty("twoPointersMade")
    public Double twoPointersMade;

    @JsonProperty("twoPointersAttempted")
    public Double twoPointersAttempted;

    @JsonProperty("twoPointersPercentage")
    public Double twoPointersPercentage;

    @JsonProperty("threePointersMade")
    public Double threePointersMade;

    @JsonProperty("threePointersAttempted")
    public Double threePointersAttempted;

    @JsonProperty("threePointersPercentage")
    public Double threePointersPercentage;

    @JsonProperty("freeThrowsMade")
    public Double freeThrowsMade;

    @JsonProperty("freeThrowsAttempted")
    public Double freeThrowsAttempted;

    @JsonProperty("freeThrowsPercentage")
    public Double freeThrowsPercentage;

    @JsonProperty("offensiveRebounds")
    public Double offensiveRebounds;

    @JsonProperty("defensiveRebounds")
    public Double defensiveRebounds;

    @JsonProperty("rebounds")
    public Double rebounds;

    @JsonProperty("offensiveReboundsPercentage")
    public Object offensiveReboundsPercentage;

    @JsonProperty("defensiveReboundsPercentage")
    public Object defensiveReboundsPercentage;

    @JsonProperty("totalReboundsPercentage")
    public Object totalReboundsPercentage;

    @JsonProperty("assists")
    public Double assists;

    @JsonProperty("steals")
    public Double steals;

    @JsonProperty("blockedShots")
    public Double blockedShots;

    @JsonProperty("turnovers")
    public Double turnovers;

    @JsonProperty("personalFouls")
    public Double personalFouls;

    @JsonProperty("points")
    public Double points;

    @JsonProperty("trueShootingAttempts")
    public Double trueShootingAttempts;

    
}
