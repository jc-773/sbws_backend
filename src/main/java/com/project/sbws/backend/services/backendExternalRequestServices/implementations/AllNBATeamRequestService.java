package com.project.sbws.backend.services.backendExternalRequestServices.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbws.backend.constants.ApplicationConstants;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IAllNBATeamsRequestService;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IRestTemplateService;


@Service
public class AllNBATeamRequestService implements IAllNBATeamsRequestService {

    @Autowired
    IRestTemplateService requestTemplateService;

    @Override
    public <T> T AllTeams_Get(Class<T> clazz) {
       String url = "https://api.sportsdata.io/v3/nba/scores/json/teams?key=" + ApplicationConstants.OcpAminSubscriptionKey;
       return (T) requestTemplateService.getForObjectResponseType(clazz, url, null);

    }
    
}