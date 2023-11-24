package com.project.sbws.backend.controllers.nba.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sbws.backend.constants.ApplicationConstants;
import com.project.sbws.backend.responses.AllTeamsResponse;
import com.project.sbws.backend.responses.PlayerByTeamResponse;
import com.project.sbws.backend.responses.containers.AllTeamsContainer;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IBackendRequestService;
import com.project.sbws.backend.services.clientRequestServices.interfaces.IPlayerService;

@Component
public class PlayersByTeamTask {

    private final IBackendRequestService requests;
    private final IPlayerService playerService;

    @Autowired
    public PlayersByTeamTask(IBackendRequestService requests, IPlayerService playerService) {
        this.requests = requests;
        this.playerService = playerService;
    }

    // @Scheduled(cron = "0 0 * * * *")
    //@Scheduled(fixedRate = 5000)
    public void getAllPlayersByTeam() {
       
        List<String> listOfTeams = getAllActiveNBATeams();
        for (int i = 0; i < listOfTeams.size(); i++) {
            List<PlayerByTeamResponse> playerByTeamList = requests
                    .PlayerByTeamResponse_Get(ApplicationConstants.OcpAminSubscriptionKey, listOfTeams.get(i));
            playerService.storeListOfPlayersOnTeam(playerByTeamList);

        }

    }

    public List<String> getAllActiveNBATeams() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, AllTeamsContainer> allTeamsContainer = new HashMap<>();
            List<AllTeamsContainer> allTeamsResponse = requests.AllNBATeams_Get();

            // flatten map down to list
            List<AllTeamsResponse> teamsList = new ArrayList<>();
            for (int i = 0; i < allTeamsResponse.size(); i++) {
                allTeamsContainer = (Map<String, AllTeamsContainer>) allTeamsResponse.get(i);
                String allTeamsResponseString = new ObjectMapper().writeValueAsString(allTeamsContainer);
                AllTeamsResponse allTeamsContainerObj = mapper.readValue(allTeamsResponseString,
                        AllTeamsResponse.class);
                teamsList.add(allTeamsContainerObj);
            }

            List<String> listOfTeamKeys = new ArrayList<>();
            for (AllTeamsResponse teams : teamsList) {
                listOfTeamKeys.add(teams.key);
            }

            for (int i = 0; i < listOfTeamKeys.size(); i++) {
                System.out.println(listOfTeamKeys.get(i));
            }

            return listOfTeamKeys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
