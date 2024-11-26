package com.project.sbws.backend.controllers.nba;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.sbws.backend.constants.ApplicationConstants;
import com.project.sbws.backend.exceptions.UserNotFoundException;
import com.project.sbws.backend.models.NBAPlayerStatsDashboard;
import com.project.sbws.backend.repositories.PlayerStatsByYearRepository;
import com.project.sbws.backend.repositories.documents.PlayerStatsBySeasonDocument;
import com.project.sbws.backend.services.implementation.NBAPlayerStatsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@Tag(name = "NBA player career stats API", description = "Search a player by their NBA.com player ID to retrieve their career stats")
public class PlayerStatsBySeason {
    
    NBAPlayerStatsService playerStatsService;
    PlayerStatsByYearRepository statsByYearRepository;

   

    @Autowired
    public PlayerStatsBySeason(PlayerStatsByYearRepository statsByYearRepository) {
        this.playerStatsService = new NBAPlayerStatsService();
        this.statsByYearRepository = statsByYearRepository;
    }

    @RequestMapping(value = "/nba/player/stats/allseasons", method=RequestMethod.GET)
    @Operation(summary = ApplicationConstants.playerStatsBySeasonControllerOperationSummary, description = ApplicationConstants.playerStatsBySeasonControllerOperationDescription)
     public List<NBAPlayerStatsDashboard> getPlayerStatsBySeason(@RequestHeader(value = "playerID", required = true) String playerID) {
                Optional<PlayerStatsBySeasonDocument> documentOptional = statsByYearRepository.findById(playerID);;
                if (documentOptional.isPresent()) {
                    PlayerStatsBySeasonDocument document = documentOptional.get();
                    return document.getStatsForYear();
                } else {
                    throw new UserNotFoundException("Player with ID {" + playerID + "} not found.");
                }
        } 
}
