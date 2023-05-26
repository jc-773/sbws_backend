package com.mysql.example.demo.responses.database;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Player_Stats_NBA_Dot_Com")
public class PlayerStatsNBADotComDocument {
    @Id
    public String playerID;
    public String gamesPlayed;
    public String fieldGoalsMade;
    public String fieldGoalsAttempted;
    public String fieldGoalPercentage;
    public String threePointPercentage;
    public String rebounds;
    public String steals;
    public String assists;
    public String blocks;

    public String getGamesPlayed() {
        return gamesPlayed;
    }
    public void setGamesPlayed(String gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }
    public String getFieldGoalsMade() {
        return fieldGoalsMade;
    }
    public void setFieldGoalsMade(String fieldGoalsMade) {
        this.fieldGoalsMade = fieldGoalsMade;
    }
    public String getFieldGoalsAttempted() {
        return fieldGoalsAttempted;
    }
    public void setFieldGoalsAttempted(String fieldGoalsAttempted) {
        this.fieldGoalsAttempted = fieldGoalsAttempted;
    }
    public String getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }
    public void setFieldGoalPercentage(String fieldGoalPercentage) {
        this.fieldGoalPercentage = fieldGoalPercentage;
    }
    public String getThreePointPercentage() {
        return threePointPercentage;
    }
    public void setThreePointPercentage(String threePointPercentage) {
        this.threePointPercentage = threePointPercentage;
    }
    public String getRebounds() {
        return rebounds;
    }
    public void setRebounds(String rebounds) {
        this.rebounds = rebounds;
    }
    public String getSteals() {
        return steals;
    }
    public void setSteals(String steals) {
        this.steals = steals;
    }
    public String getAssists() {
        return assists;
    }
    public void setAssists(String assists) {
        this.assists = assists;
    }
    public String getBlocks() {
        return blocks;
    }
    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    
}
