package com.project.sbws.backend.services.implementation.requests;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.services.interfaces.requests.INBAPlayerRequestService;

@Service
public class NBAPlayerRequestService implements INBAPlayerRequestService {

    @Autowired
    private BackendRequestService nbaPlayerRequests;

    // @Autowired
    // public NBAPlayerRequestService() {
    //     this.nbaPlayerRequests = new BackendRequestService();
    // }

    @Override
    @Cacheable("playerCareerStats")
    public  Map<String, PlayerStatsNBADotCom> PlayerCareerStats(String playerID) {
       return ( Map<String, PlayerStatsNBADotCom>) nbaPlayerRequests.PlayerCareerStats(PlayerStatsNBADotCom.class, playerID); 
    }

}
