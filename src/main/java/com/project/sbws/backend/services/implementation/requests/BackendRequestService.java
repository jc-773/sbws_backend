package com.project.sbws.backend.services.implementation.requests;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbws.backend.services.interfaces.requests.IBackendRequestService;
import com.project.sbws.backend.services.interfaces.requests.IRestTemplateService;

@Service
public class BackendRequestService implements IBackendRequestService {
  
    IRestTemplateService requestTemplateService;

    @Autowired
    public BackendRequestService(IRestTemplateService requestTemplateService) {
        this.requestTemplateService = requestTemplateService;
    }

    @Override
    public <T> T PlayerCareerStats(Class<T> clazz, String playerID) {
        String url = "https://stats.nba.com/stats/playerdashboardbyyearoveryearcombined?DateFrom=&DateTo=&GameSegment=&LastNGames=0&LeagueID=00&Location=&MeasureType=Base&Month=0&OpponentTeamID=0&Outcome=&PORound=0&PaceAdjust=N&PerMode=PerGame&Period=0&PlayerID="
                + playerID
                + "&PlusMinus=N&Rank=N&Season=2022-23&SeasonSegment=&SeasonType=Regular Season&ShotClockRange=&VsConference=&VsDivision=";
        Hashtable<String, String> customHeaders = new Hashtable<String, String>();
        customHeaders.put("Accept", "*/*");
        customHeaders.put("User-Agent", "PostmanRuntime/7.31.3");
        customHeaders.put("Referer", "https://www.nba.com/");
        return (T) requestTemplateService.getForObjectResponse(clazz, url, customHeaders);
    }


    @Override
    public <T> T PlayersOnCurrentTeamRoster(Class<T> clazz, String teamName) {
        //Would be better to use a string builder here
        String team = teamName.replace("\"", "");
        String url = "https://api.sportsdata.io/v3/nba/scores/json/Players/" + team + "?key=cdbf378501a14087a04a26191b9fd67c";
        Hashtable<String, String> customHeaders = new Hashtable<String, String>();
        customHeaders.put("Accept", "*/*");
        return (T) requestTemplateService.getForObjectResponse(clazz, url, customHeaders);
    }

   
}
