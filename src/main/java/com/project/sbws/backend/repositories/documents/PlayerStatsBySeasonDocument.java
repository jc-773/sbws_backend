package com.project.sbws.backend.repositories.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.sbws.backend.models.NBAPlayerStatsDashboard;

@Document(collection = "playerStatsBySeason")
public class PlayerStatsBySeasonDocument {
    @Id
    private String playerID;

    private List<NBAPlayerStatsDashboard> statsForYear;

    // Getters and Setters

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public List<NBAPlayerStatsDashboard> getStatsForYear() {
        return statsForYear;
    }

    public void setStatsForYear(List<NBAPlayerStatsDashboard> statsForYear) {
        this.statsForYear = statsForYear;
    }
}
