package com.mysql.example.demo.services.backendExternalRequestServices.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.example.demo.constants.ApplicationConstants;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IAllNBATeamsRequestService;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IRestTemplateService;

@Service
public class AllNBATeamRequestService implements IAllNBATeamsRequestService {

    private IRestTemplateService requestTemplateService;

    @Autowired
    public AllNBATeamRequestService(IRestTemplateService requestTemplateService) {
        this.requestTemplateService = requestTemplateService;
    } 

    @Override
    public <T> T AllTeams_Get(Class<T> clazz) {
       String url = "https://api.sportsdata.io/v3/nba/scores/json/teams?key=" + ApplicationConstants.OcpAminSubscriptionKey;
       return (T) requestTemplateService.getForObjectResponseType(clazz, url, null);

    }
    
}
