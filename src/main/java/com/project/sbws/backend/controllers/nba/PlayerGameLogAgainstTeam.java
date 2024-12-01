package com.project.sbws.backend.controllers.nba;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.sbws.backend.exceptions.UserNotFoundException;
import com.project.sbws.backend.models.PlayerGameLogs;
import com.project.sbws.backend.repositories.PlayerOppontMatchupAllMatchupsLifetimeRepository;
import com.project.sbws.backend.repositories.documents.PlayerOppontMatchupAllMatchupsLifetimeDocument;
import com.project.sbws.backend.services.implementation.requests.RestTemplateService;


@RestController
public class PlayerGameLogAgainstTeam {
    private static final Logger log = LoggerFactory.getLogger(RestTemplateService.class);
    PlayerOppontMatchupAllMatchupsLifetimeRepository playerOppontMatchupAllMatchupsLifetimeRepository;

    @Autowired
    public PlayerGameLogAgainstTeam(PlayerOppontMatchupAllMatchupsLifetimeRepository playerOppontMatchupAllMatchupsLifetimeRepository) {
        this.playerOppontMatchupAllMatchupsLifetimeRepository = playerOppontMatchupAllMatchupsLifetimeRepository;
    }
    
    @RequestMapping(value = "/nba/player/matchup", method=RequestMethod.GET)
     public List<PlayerGameLogs> getPlayerStatsBySeason(
        @RequestParam(value = "playerID", required = true)String playerID, 
        @RequestParam(value="matchup", required = true) String matchup ) {
        try {
               Optional<PlayerOppontMatchupAllMatchupsLifetimeDocument> playerLifetimeMatchupDocument = playerOppontMatchupAllMatchupsLifetimeRepository.findByPlayerIdAndMatchup(playerID, matchup);
               if(playerLifetimeMatchupDocument.isPresent()) {
                List<PlayerGameLogs> gameLogs = playerLifetimeMatchupDocument.get().getGameLog();
                return gameLogs;
               }else {
                 throw new UserNotFoundException("Player with ID {" + playerID + "} not found.");
               }
        } catch (Exception e) {
           log.error("Unexpected error occurred while retrieving player stats for ID: {}", playerID, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
     }
}
