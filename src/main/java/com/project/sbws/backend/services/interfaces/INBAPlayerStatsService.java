package com.project.sbws.backend.services.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.project.sbws.backend.responses.NBADotComPlayerStatsRowSet;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;

public interface INBAPlayerStatsService {
    public ResponseEntity<List<NBADotComPlayerStatsRowSet>> getPlayerCareerStats(String playerID, Map<String, PlayerStatsNBADotCom> playerStats);
}
