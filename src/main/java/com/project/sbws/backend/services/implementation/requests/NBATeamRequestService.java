package com.project.sbws.backend.services.implementation.requests;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbws.backend.responses.PlayerInfoByTeam;
import com.project.sbws.backend.services.interfaces.requests.IBackendRequestService;
import com.project.sbws.backend.services.interfaces.requests.INBATeamRequestService;

@Service
public class NBATeamRequestService implements INBATeamRequestService {

    IBackendRequestService backendRequestService;

    @Autowired
    public NBATeamRequestService(IBackendRequestService backendRequestService) {
      this.backendRequestService = backendRequestService;
    }

    @Override
    public  List<LinkedHashMap> playersOnCurrentTeamRoster(String teamName) {
       return ( List<LinkedHashMap>) backendRequestService.PlayersOnCurrentTeamRoster(PlayerInfoByTeam.class, teamName); 
    }
    
}
