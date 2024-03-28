package com.project.sbws.backend.services.clientRequestServices.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.services.clientRequestServices.interfaces.IPlayerService;

@Service
public class PlayerService implements IPlayerService {

    // @Autowired
    // PlayerProfileDataService playerProfileDataService;

    /* Utilities */

   

    private Map<String, Object> processJsonForOverallBasePlayerDashboardMap(Map<String, PlayerStatsNBADotCom> map,
            String playerID) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.putIfAbsent("playerID", playerID);
            String playerStatsJsonString = new ObjectMapper().writeValueAsString(map);
            PlayerStatsNBADotCom readValue = mapper.readValue(playerStatsJsonString, PlayerStatsNBADotCom.class);

            // refactor to get every year and not just one year (the one year was POC)

            if (readValue.resultSets.size() > 0) {
                List<List<Object>> rowSetList = readValue.resultSets.get(0).rowSet;
                List<String> headersList = readValue.resultSets.get(0).headers;
                for (Object oj : rowSetList) {
                    List<Object> ot = (List<Object>) oj;
                    for (int i = 0; i < ot.size(); i++) {
                        returnMap.put(headersList.get(i), ot.get(i));
                    }
                    // playerProfileDataService.saveOverallBasePlayerDashboardFromNBADotCom(returnMap);
                }
            }

            return returnMap;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

   
    @Override // NBA.com Player Stats Dashboard Task
    public void saveOverallBasePlayerDashboardFromNBADotCom(Integer playerID,
            Map<String, PlayerStatsNBADotCom> playerStat) {
        try {

            // Query by playerID and store into a response object
            // Once complete response is stored in an object, flatten to a client response
            // and return it here
            Map<String, Object> overallBasePlayerDashboard_NBADotCom_Map = processJsonForOverallBasePlayerDashboardMap(
                    playerStat, playerID.toString());

            Map<String, String> newMap = new HashMap<String, String>();
            for (Map.Entry<String, Object> entry : overallBasePlayerDashboard_NBADotCom_Map.entrySet()) {
                if (entry.getValue() instanceof Object) {

                    newMap.put(entry.getKey(), (String) entry.getValue().toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* End Implementation Methods */
}
