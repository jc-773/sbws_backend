package com.project.sbws.backend.services.dataServices.interfaces;

import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.responses.database.PlayerStatsNBADotComDocument;

public interface IPlayerBySeasonDataLayerService {

    public PlayerStatsNBADotComDocument getPlayerBySeasonStatsByPlayerID(String playerID);
}