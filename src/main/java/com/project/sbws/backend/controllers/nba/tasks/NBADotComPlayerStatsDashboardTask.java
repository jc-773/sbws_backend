package com.project.sbws.backend.controllers.nba.tasks;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    //@Scheduled(fixedRate = 500000)
    public void getAllActivePlayerNBADotComStats() {
        try {
            /**
             * Grab every playerID, store it in a list, make the call NBA dot com to get that player's stats, and then save it to the database
             * 
             * List of teams --> List of player IDs from that team --> store in list --> loop through list to nba com 
             * 
             */

             //get x team
             List<String> teamList = ReadCSV.readCommaSeparatedValuesAndStoreInAList("src/main/resources/NBATeamsCSV.txt");
             
             ObjectMapper mapper = new ObjectMapper();
            for (String team : teamList) {
                List<LinkedHashMap> playerList = teamRequestService.playersOnCurrentTeamRoster(team);
                System.out.println("Active roster size: " + playerList.size());

                for(int i = 0; i < playerList.size(); i++) {
                    System.out.println("Player: " + playerList.get(i));
                    PlayerInfoByTeam p = mapper.convertValue(playerList.get(i), PlayerInfoByTeam.class);
                    String firstName = p.firstName;
                    System.out.println("First name: " + firstName);
                    // Now you can use p
                }
            }

                //get nba dot com player ID and make call for stats


             //this will make the request to get the team with the passed in arguments teamName and year
             


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
