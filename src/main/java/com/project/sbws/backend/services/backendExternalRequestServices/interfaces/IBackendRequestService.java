package com.project.sbws.backend.services.backendExternalRequestServices.interfaces;

import java.util.Map;


import com.project.sbws.backend.responses.PlayerStatsNBADotCom;

public interface IBackendRequestService {
    public Map<String, PlayerStatsNBADotCom> PlayerCareerStats(String playerID);
}
