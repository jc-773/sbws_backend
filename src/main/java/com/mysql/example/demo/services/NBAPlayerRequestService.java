package com.mysql.example.demo.services;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.services.interfaces.INBAPlayerRequestService;
import com.mysql.example.demo.services.interfaces.IRestTemplateService;

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
        customHeaders.put("Ocp-Apim-Subscription-Key", "cdbf378501a14087a04a26191b9fd67c");
        //PlayerResponse[] response = requestTemplateService.getForObjectResponse(PlayerResponse[].class, url, customHeaders);
        return (T) requestTemplateService.getForObjectResponse(PlayerResponse[].class, url, customHeaders);
    }

    @Override
    public <T> T PlayerProjection_Get(Class<PlayerProjectionResponse> clazz, String token, String playerId,
            String date) {
                String url = "https://api.sportsdata.io/v3/nba/projections/json/PlayerGameProjectionStatsByPlayer/" + date + "/" + playerId;
                Hashtable<String, String> customHeaders = new Hashtable<String, String>();
                customHeaders.put("Ocp-Apim-Subscription-Key", "cdbf378501a14087a04a26191b9fd67c");
                //PlayerResponse[] response = requestTemplateService.getForObjectResponse(PlayerResponse[].class, url, customHeaders);
                return (T) requestTemplateService.getForObjectResponseType(clazz, url, customHeaders);
    }

  
    
}