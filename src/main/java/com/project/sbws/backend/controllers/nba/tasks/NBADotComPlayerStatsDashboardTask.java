package com.project.sbws.backend.controllers.nba.tasks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.project.sbws.backend.responses.PlayerInfoByTeam;
import com.project.sbws.backend.services.implementation.requests.NBATeamRequestService;
import com.project.sbws.backend.services.interfaces.requests.IBackendRequestService;
import com.project.sbws.backend.utilities.ReadCSV;

@Component
public class NBADotComPlayerStatsDashboardTask {

    private final IBackendRequestService requests;
    private final NBATeamRequestService teamRequestService;

    @Autowired
    public NBADotComPlayerStatsDashboardTask( IBackendRequestService requests, NBATeamRequestService teamRequestService) {
        this.requests = requests;
        this.teamRequestService = teamRequestService;
    }

    // @Scheduled(fixedRate = 5000)
    // public void getAllActivePlayerNBADotComStats() {
    //     try {
    //         /**
    //          * Grab every playerID, store it in a list, make the call NBA dot com to get that player's stats, and then save it to the database
    //          * 
    //          * List of teams --> List of player IDs from that team --> store in list --> loop through list to nba com 
    //          * 
    //          */

    //          //get x team
    //          List<String> teamList = ReadCSV.readCommaSeparatedValuesAndStoreInAList("src/main/resources/NBATeamsCSV.txt");
             
    //          for (String team : teamList) {
    //             List<PlayerInfoByTeam> playerList = teamRequestService.playersOnCurrentTeamRoster(team);
    //             System.out.println("Active roster size: " + playerList.size());


    //             //get nba dot com player ID and make call for stats


    //          }
    //          //this will make the request to get the team with the passed in arguments teamName and year
             


    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }

    // }
}
