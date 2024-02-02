package com.project.sbws.backend.controllers.nba.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.sbws.backend.services.clientRequestServices.interfaces.IPlayerService;

@Component
public class NBADotComPlayerMatchupStatsAgainstTeam {
    
    private final IPlayerService playerService;

    @Autowired
    public NBADotComPlayerMatchupStatsAgainstTeam(IPlayerService playerService) {
        this.playerService = playerService;
    }

    public void getPlayerMathupStatisticsAgainstCertainTeam() {
        //list of all players player IDs
        // list of all teams team IDs 
        // make a call for a player ID that loops through all team IDs or something

        List<Integer> listOfPlayerIDs = playerService.returnAllPlayerIds();
        

    }
}
