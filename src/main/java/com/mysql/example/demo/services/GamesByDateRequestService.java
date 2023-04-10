package com.mysql.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.example.demo.responses.GamesByDate;
import com.mysql.example.demo.services.interfaces.IGamesByDateRequestService;
import com.mysql.example.demo.services.interfaces.IRestTemplateService;

@Service
public class GamesByDateRequestService implements IGamesByDateRequestService{

    private IRestTemplateService requestTemplateService;

    @Autowired
    public GamesByDateRequestService(IRestTemplateService requestTemplateService) {
        this.requestTemplateService = requestTemplateService;
    }    

    @Override
    public <T> T GamesByDateResponse_Get(Class<T> clazz, String date, String key) {
       String url = "https://api.sportsdata.io/v3/nba/scores/json/ScoresBasic/" + date + "?key=" + key;
       return (T) requestTemplateService.getForObjectResponse(GamesByDate[].class, url, null);

    }
    
}
