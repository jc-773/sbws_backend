package com.mysql.example.demo.responses.mobile;

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

    public PlayerProfileResponseType() {

    }

    public PlayerProfileResponseType(String playerID, String team, String firstName, String lastName) {
        this.playerID = playerID;
        this.team = team;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    

    public PlayerProfileResponseType(String playerID, String status, String team, String position,
            String firstName, String lastName, Double projectedThreesMade, Double projectedRebounds,
            Double projectedAssists, Double projectedPoints) {
        this.playerID = playerID;
        this.status = status;
        this.team = team;
        this.position = position;
        this.firstName = firstName;
        this.lastName = lastName;
        this.projectedThreesMade = projectedThreesMade;
        this.projectedRebounds = projectedRebounds;
        this.projectedAssists = projectedAssists;
        this.projectedPoints = projectedPoints;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getProjectedThreesMade() {
        return projectedThreesMade;
    }

    public void setProjectedThreesMade(Double projectedThreesMade) {
        this.projectedThreesMade = projectedThreesMade;
    }

    public Double getProjectedRebounds() {
        return projectedRebounds;
    }

    public void setProjectedRebounds(Double projectedRebounds) {
        this.projectedRebounds = projectedRebounds;
    }

    public Double getProjectedAssists() {
        return projectedAssists;
    }

    public void setProjectedAssists(Double projectedAssists) {
        this.projectedAssists = projectedAssists;
    }

    public Double getProjectedPoints() {
        return projectedPoints;
    }

    public void setProjectedPoints(Double projectedPoints) {
        this.projectedPoints = projectedPoints;
    }


    
}
