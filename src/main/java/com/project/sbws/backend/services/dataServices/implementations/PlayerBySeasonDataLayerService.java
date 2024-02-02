package com.project.sbws.backend.services.dataServices.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbws.backend.repositories.PlayerStatsBySeasonRepository;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.responses.database.PlayerStatsNBADotComDocument;
import com.project.sbws.backend.services.dataServices.interfaces.IPlayerBySeasonDataLayerService;

@Service
public class PlayerBySeasonDataLayerService implements IPlayerBySeasonDataLayerService {

    @Autowired
    PlayerStatsBySeasonRepository playerStatsBySeasonRepository;

    @Override
    public PlayerStatsNBADotComDocument getPlayerBySeasonStatsByPlayerID(String playerID) {
       try {
        
       } catch (Exception e) {
     
       }
       return null;
    }
    
}
