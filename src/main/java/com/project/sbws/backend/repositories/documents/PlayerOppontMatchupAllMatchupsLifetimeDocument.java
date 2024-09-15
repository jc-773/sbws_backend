package com.project.sbws.backend.repositories.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.sbws.backend.models.PlayerGameLogs;

@Document(collection = "playerOppontMatchupAllMatchupsLifetime")
public class PlayerOppontMatchupAllMatchupsLifetimeDocument {
    @Id
    private String playerID;

    public List<PlayerGameLogs> gameLog;

    // Getters and Setters

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public List<PlayerGameLogs> getGameLog() {
        return gameLog;
    }

    public void setGameLog(List<PlayerGameLogs> gameLog) {
        this.gameLog = gameLog;
    }
}
