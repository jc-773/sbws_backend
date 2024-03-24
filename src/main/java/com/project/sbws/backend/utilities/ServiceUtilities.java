package com.project.sbws.backend.utilities;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;

public class ServiceUtilities {
    
    public <T> PlayerStatsNBADotCom flattenPlayerProjectionByDateMap(Map<String, PlayerStatsNBADotCom> playerStats, Class<PlayerStatsNBADotCom> class1) {
        try {

           ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> returnMap = new HashMap<>();
            String playerStatsJsonString = new ObjectMapper().writeValueAsString(playerStats);
           return mapper.readValue(playerStatsJsonString, PlayerStatsNBADotCom.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
