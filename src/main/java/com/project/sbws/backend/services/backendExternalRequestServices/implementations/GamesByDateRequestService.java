package com.project.sbws.backend.services.backendExternalRequestServices.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sbws.backend.responses.GamesByDate;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IGamesByDateRequestService;
import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IRestTemplateService;


@Service
public class GamesByDateRequestService implements IGamesByDateRequestService{

    @Autowired
    private IRestTemplateService requestTemplateService;

    @Override
    public <T> T GamesByDateResponse_Get(Class<T> clazz, String date, String key) {
       String url = "https://api.sportsdata.io/v3/nba/scores/json/ScoresBasic/" + date + "?key=" + key;
       return (T) requestTemplateService.getForObjectResponse(GamesByDate[].class, url, null);

    }
    
}
