package com.project.sbws.backend.services.interfaces.requests;

import java.util.Map;

import com.project.sbws.backend.responses.PlayerStatsNBADotCom;

public interface INBAPlayerRequestService {
     Map<String, PlayerStatsNBADotCom> PlayerCareerStats(String playerID);
}

