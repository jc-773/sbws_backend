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

    private IRestTemplateService requestTemplateService;
    
   @Autowired
    public NBAPlayerRequestService(IRestTemplateService requestTemplateService) {
        this.requestTemplateService = requestTemplateService;
    }
    
    @Override
    public <T> T PlayerResponse_Get(Class<T> clazz, String token) {
        String url = "https://api.sportsdata.io/v3/nba/scores/json/Players";
        Hashtable<String, String> customHeaders = new Hashtable<String, String>();
        customHeaders.put("Ocp-Apim-Subscription-Key", ApplicationConstants.OcpAminSubscriptionKey);
        //PlayerResponse[] response = requestTemplateService.getForObjectResponse(PlayerResponse[].class, url, customHeaders);
        return (T) requestTemplateService.getForObjectResponse(PlayerResponse[].class, url, customHeaders);
    }

    @Override
    public <T> T PlayerProjection_Get(Class<PlayerProjectionResponse> clazz, String token, String playerId,
            String date) {
                String url = "https://api.sportsdata.io/v3/nba/projections/json/PlayerGameProjectionStatsByPlayer/" + date + "/" + playerId;
                Hashtable<String, String> customHeaders = new Hashtable<String, String>();
                customHeaders.put("Ocp-Apim-Subscription-Key", ApplicationConstants.OcpAminSubscriptionKey);
                //PlayerResponse[] response = requestTemplateService.getForObjectResponse(PlayerResponse[].class, url, customHeaders);
                return (T) requestTemplateService.getForObjectResponseType(clazz, url, customHeaders);
    }

    @Override
    public <T> T PlayerByTeamResponse_Get(Class<T> clazz, String key, String team) {
       String url = "https://api.sportsdata.io/v3/nba/scores/json/Players/" + team + "?key=" + key;
       return (T) requestTemplateService.getForObjectResponse(clazz, url, null);

    }

    
  
    
}
