package com.project.sbws.backend.controllers.nba;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sbws.backend.models.PlayerGameLogs;
import com.project.sbws.backend.repositories.PlayerOppontMatchupAllMatchupsLifetimeRepository;
import com.project.sbws.backend.repositories.documents.PlayerOppontMatchupAllMatchupsLifetimeDocument;


@RestController
public class PlayerGameLogAgainstTeam {

     @Autowired
    private PlayerOppontMatchupAllMatchupsLifetimeRepository playerOppontMatchupAllMatchupsLifetimeRepository;
    
    @RequestMapping(value = "/nba/player/matchup", method=RequestMethod.GET)
     public List<PlayerGameLogs> getPlayerStatsBySeason(
        @RequestParam(value = "playerID", required = true)String playerID, 
        @RequestParam(value="matchup", required = true) String matchup ) {
        try {
               List<PlayerOppontMatchupAllMatchupsLifetimeDocument> documentOptional = playerOppontMatchupAllMatchupsLifetimeRepository.findByPlayerIdAndMatchup(playerID, matchup);
               List<PlayerGameLogs> gameLogs = documentOptional.get(0).getGameLog();
               return gameLogs;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }
}
