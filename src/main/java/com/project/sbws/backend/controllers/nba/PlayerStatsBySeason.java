package com.project.sbws.backend.controllers.nba;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.sbws.backend.models.NBAPlayerStatsDashboard;
import com.project.sbws.backend.repositories.PlayerStatsByYearRepository;
import com.project.sbws.backend.repositories.documents.PlayerStatsBySeasonDocument;
import com.project.sbws.backend.services.implementation.NBAPlayerStatsService;
import com.project.sbws.backend.services.interfaces.IBackendRequestService;


@RestController
public class PlayerStatsBySeason {
    
    IBackendRequestService backendRequestService;
    NBAPlayerStatsService playerStatsService;
    PlayerStatsByYearRepository statsByYearRepository;
   

    @Autowired
    public PlayerStatsBySeason(IBackendRequestService backendRequestService, PlayerStatsByYearRepository statsByYearRepository) {
        this.backendRequestService = backendRequestService;
        this.playerStatsService = new NBAPlayerStatsService();
        this.statsByYearRepository = statsByYearRepository;
    }

    @RequestMapping(value = "/nba/player/stats/allseasons", method=RequestMethod.GET)
     public List<NBAPlayerStatsDashboard> getPlayerStatsBySeason(@RequestHeader(value = "playerID", required = false)String playerID) {
        try {
                //Map<String, PlayerStatsNBADotCom> playerStats = backendRequestService.PlayerCareerStats(playerID);
                //return playerStatsService.getPlayerCareerStats(playerStats);
                
                Optional<PlayerStatsBySeasonDocument> documentOptional = statsByYearRepository.findById(playerID);;
                if (documentOptional.isPresent()) {
                    PlayerStatsBySeasonDocument document = documentOptional.get();
                    return document.getStatsForYear();
                } else {
                    return null; // or throw an exception if that's more appropriate
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }
}
