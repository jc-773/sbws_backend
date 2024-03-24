package com.project.sbws.backend.services.clientRequestServices.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sbws.backend.responses.NBADotComPlayerStatsRowSet;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.responses.ResultSets;
import com.project.sbws.backend.services.clientRequestServices.interfaces.INBAPlayerStatsService;
import com.project.sbws.backend.utilities.ServiceUtilities;

public class NBAPlayerStatsService implements INBAPlayerStatsService {

    private ServiceUtilities serviceUtilities;

    public NBAPlayerStatsService() {
        this.serviceUtilities = new ServiceUtilities();
    }

    @Override
    public ResponseEntity<List<NBADotComPlayerStatsRowSet>> getPlayerCareerStats(
            Map<String, PlayerStatsNBADotCom> playerStats) {
        try {
            PlayerStatsNBADotCom playerStatsBySeason = serviceUtilities.flattenPlayerProjectionByDateMap(playerStats,
                    PlayerStatsNBADotCom.class);

            ResultSets basePlayerDashboardSet = playerStatsBySeason.resultSets
                    .stream().filter(n -> n.name.equals("ByYearBasePlayerDashboard")).findAny().orElse(null);

            List<NBADotComPlayerStatsRowSet> basePlayerDashboardByYear = getBasePlayerDashboardByYear(
                    basePlayerDashboardSet);

            return new ResponseEntity<List<NBADotComPlayerStatsRowSet>>(basePlayerDashboardByYear, HttpStatus.OK);
        } catch (

        Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<NBADotComPlayerStatsRowSet> getBasePlayerDashboardByYear(ResultSets basePlayerDashboardSet) {
        List<NBADotComPlayerStatsRowSet> basePlayerDashboardByYear = new ArrayList<>();
        if (basePlayerDashboardSet != null) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String json = "";
                Map<String, Object> seasonsMap = new HashMap<>();
                List<String> headers = basePlayerDashboardSet.headers;

                int x = 0;
                int seasons = basePlayerDashboardSet.rowSet.size();

                while (x < seasons) {
                    List<Object> seasonValues = basePlayerDashboardSet.rowSet.get(x);
                    for (int j = 0; j < headers.size(); j++) {
                        seasonsMap.put(headers.get(j), seasonValues.get(j));
                    }
                    json = objectMapper.writeValueAsString(seasonsMap);
                    NBADotComPlayerStatsRowSet basePlayerDashboard = objectMapper.readValue(json,
                            NBADotComPlayerStatsRowSet.class);
                    basePlayerDashboardByYear.add(basePlayerDashboard);
                    x++;

                }
                return basePlayerDashboardByYear;
            } catch (Exception e) {
                e.printStackTrace();
        }
    }
        return null;
    }
}