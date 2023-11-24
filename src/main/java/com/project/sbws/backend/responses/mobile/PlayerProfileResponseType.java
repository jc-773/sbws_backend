package com.project.sbws.backend.responses.mobile;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document("playerProfile")
public class PlayerProfileResponseType {

    @Id
    @JsonProperty("playerID")
    public String playerID;

    @JsonProperty("draftKindsPlayerID")
    public String draftKindsPlayerID;

    @JsonProperty("fanDuelPlayerID")
    public String fanDuelPlayerID;

    @JsonProperty("nbaDotComPlayerID")
    public String nbaDotComPlayerID;

    @JsonProperty("rotoWirePlayerID")
    public String rotoWirePlayerID;

    @JsonProperty("teamID")
    public String teamID;

    @JsonProperty("status")
    public String status;

    @JsonProperty("team")
    public String team;

    @JsonProperty("position")
    public String position;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("projectedThreesMade")
    public Double projectedThreesMade;

    @JsonProperty("projectedRebounds")
    public Double projectedRebounds;

    @JsonProperty("projectedAssists")
    public Double projectedAssists;

    @JsonProperty("projectedPoints")
    public Double projectedPoints;

    
}
