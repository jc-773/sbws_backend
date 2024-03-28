package com.project.sbws.backend.services.backendExternalRequestServices.implementations;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.INBAPlayerRequestService;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IRestTemplateService;

@Service
public class NBAPlayerRequestService implements INBAPlayerRequestService {

    @Autowired
    private IRestTemplateService requestTemplateService;

   
    @Override
    public <T> T PlayerCareerStats(Class<T> clazz, String playerID) {
        String url = "https://stats.nba.com/stats/playerdashboardbyyearoveryearcombined?DateFrom=&DateTo=&GameSegment=&LastNGames=0&LeagueID=00&Location=&MeasureType=Base&Month=0&OpponentTeamID=0&Outcome=&PORound=0&PaceAdjust=N&PerMode=PerGame&Period=0&PlayerID="
                + playerID
                + "&PlusMinus=N&Rank=N&Season=2022-23&SeasonSegment=&SeasonType=Regular Season&ShotClockRange=&VsConference=&VsDivision=";
        Hashtable<String, String> customHeaders = new Hashtable<String, String>();
        customHeaders.put("Accept", "*/*");
        customHeaders.put("User-Agent", "PostmanRuntime/7.31.3");
        customHeaders.put("Referer", "https://www.nba.com/");
        // customHeaders.put("Cache-Control", "no-cache");
        return (T) requestTemplateService.getForObjectResponse(clazz, url, customHeaders);
    }

}
