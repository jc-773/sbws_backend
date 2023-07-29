package com.mysql.example.demo.services.backendExternalRequestServices.implementations;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.example.demo.constants.ApplicationConstants;
import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.INBAPlayerRequestService;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IRestTemplateService;

@Service
public class NBAPlayerRequestService implements INBAPlayerRequestService {

    @Autowired
    private IRestTemplateService requestTemplateService;
   
    @Override
    public <T> T PlayerResponse_Get(Class<T> clazz, String token) {
        String url = "https://api.sportsdata.io/v3/nba/scores/json/Players";
        Hashtable<String, String> customHeaders = new Hashtable<String, String>();
        customHeaders.put("Ocp-Apim-Subscription-Key", ApplicationConstants.OcpAminSubscriptionKey);
        return (T) requestTemplateService.getForObjectResponse(PlayerResponse[].class, url, customHeaders);
    }

    @Override
    public <T> T PlayerProjection_Get(Class<PlayerProjectionResponse> clazz, String token, String playerId,
            String date) {
                String url = "https://api.sportsdata.io/v3/nba/projections/json/PlayerGameProjectionStatsByPlayer/" + date + "/" + playerId;
                Hashtable<String, String> customHeaders = new Hashtable<String, String>();
                customHeaders.put("Ocp-Apim-Subscription-Key", ApplicationConstants.OcpAminSubscriptionKey);
                return (T) requestTemplateService.getForObjectResponseType(clazz, url, customHeaders);
    }

    @Override
    public <T> T PlayerByTeamResponse_Get(Class<T> clazz, String key, String team) {
       String url = "https://api.sportsdata.io/v3/nba/scores/json/Players/" + team + "?key=" + key;
       return (T) requestTemplateService.getForObjectResponse(clazz, url, null);

    }

    @Override
    public <T> T PlayerCareerStats(Class<T> clazz, String playerID) {
        String url = "https://stats.nba.com/stats/playerdashboardbyyearoveryearcombined?DateFrom=&DateTo=&GameSegment=&LastNGames=0&LeagueID=00&Location=&MeasureType=Base&Month=0&OpponentTeamID=0&Outcome=&PORound=0&PaceAdjust=N&PerMode=PerGame&Period=0&PlayerID=" + playerID + "&PlusMinus=N&Rank=N&Season=2022-23&SeasonSegment=&SeasonType=Regular Season&ShotClockRange=&VsConference=&VsDivision=";
        Hashtable<String, String> customHeaders = new Hashtable<String, String>();
         customHeaders.put("Accept", "*/*");
         customHeaders.put("User-Agent", "PostmanRuntime/7.31.3");
        customHeaders.put("Referer", "https://www.nba.com/");
       // customHeaders.put("Cache-Control", "no-cache");
        return (T) requestTemplateService.getForObjectResponse(clazz, url, customHeaders);
    }

    
  
    
}
