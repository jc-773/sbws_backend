package com.project.sbws.backend.services.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.sbws.backend.responses.NBADotComPlayerStatsRowSet;
import com.project.sbws.backend.responses.PlayerStatsNBADotCom;
import com.project.sbws.backend.responses.ResultSets;
import com.project.sbws.backend.services.interfaces.INBAPlayerStatsService;
import com.project.sbws.backend.utilities.ServiceUtilities;

@Service
public class NBAPlayerStatsService implements INBAPlayerStatsService {

    private ServiceUtilities serviceUtilities;

    public NBAPlayerStatsService() {
        this.serviceUtilities = new ServiceUtilities();
    }

    @Override
    public ResponseEntity<List<NBADotComPlayerStatsRowSet>> getPlayerCareerStats(Map<String, PlayerStatsNBADotCom> playerStats) {
        try {
            List<NBADotComPlayerStatsRowSet> basePlayerDashboardByYear = filterPlayerStatsMapToBasePlayerDashboard(playerStats);

            return new ResponseEntity<List<NBADotComPlayerStatsRowSet>>(basePlayerDashboardByYear, HttpStatus.OK);
        } catch (

        Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NBADotComPlayerStatsRowSet> filterPlayerStatsMapToBasePlayerDashboard (Map<String, PlayerStatsNBADotCom> playerStats) {
        PlayerStatsNBADotCom playerStatsBySeason = serviceUtilities.flattenPlayerProjectionByDateMap(playerStats,
                    PlayerStatsNBADotCom.class);

            ResultSets basePlayerDashboardSet = playerStatsBySeason.resultSets
                    .stream().filter(n -> n.name.equals("ByYearBasePlayerDashboard")).findAny().orElse(null);

            return getBasePlayerDashboardByYear(basePlayerDashboardSet);
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