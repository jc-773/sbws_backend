package com.project.sbws.backend.services.implementation.requests;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.services.implementation.redis.RedisPlayerStatsBySeasonService;
import com.project.sbws.backend.services.interfaces.requests.INBAPlayerRequestService;

@Service
public class NBAPlayerRequestService implements INBAPlayerRequestService {

    @Autowired
    private BackendRequestService nbaPlayerRequests;
    @Autowired
    private RedisPlayerStatsBySeasonService playerCachingService;

    @Override
    public Map<String, PlayerStatsNBADotCom> PlayerCareerStats(String playerID) {
        Map<String, PlayerStatsNBADotCom> player = playerCachingService.getValue(playerID);
        if (player == null) {
            player = (Map<String, PlayerStatsNBADotCom>) nbaPlayerRequests.PlayerCareerStats(PlayerStatsNBADotCom.class,
            playerID);
            playerCachingService.savePlayerStatsBySeason(playerID, player);
            return player;
        }
        return player;
    }

}
