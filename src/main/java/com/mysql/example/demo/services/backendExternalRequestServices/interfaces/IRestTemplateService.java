package com.mysql.example.demo.services.backendExternalRequestServices.interfaces;

import java.util.Hashtable;

import com.mysql.example.demo.responses.PlayerProjectionResponse;

public interface IRestTemplateService {
    public <PlayerStatsNBADotCom> PlayerStatsNBADotCom getForObjectResponse(Class<PlayerStatsNBADotCom> clazz, String url, Hashtable<String, String> customHeaders);
    public <T, R> T getForObjectResponseType(Class<T> clazz, String url, Hashtable<String, String> customHeaders);
}
