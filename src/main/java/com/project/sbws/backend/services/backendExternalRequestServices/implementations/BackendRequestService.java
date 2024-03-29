package com.project.sbws.backend.services.backendExternalRequestServices.implementations;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IBackendRequestService;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.INBAPlayerRequestService;



@Service
public class BackendRequestService implements IBackendRequestService {
    
    @Autowired
    INBAPlayerRequestService nbaPlayerRequests;

  
    @Override
    public  Map<String, PlayerStatsNBADotCom> PlayerCareerStats(String playerID) {
       
       return ( Map<String, PlayerStatsNBADotCom>) nbaPlayerRequests.PlayerCareerStats(PlayerStatsNBADotCom.class, playerID); 
    }
}
