package com.project.sbws.backend.services.interfaces.requests;

import java.util.Hashtable;



public interface IRestTemplateService {
    public <PlayerStatsNBADotCom> PlayerStatsNBADotCom getForObjectResponse(Class<PlayerStatsNBADotCom> clazz, String url, Hashtable<String, String> customHeaders);
    public <T, R> T getForObjectResponseType(Class<T> clazz, String url, Hashtable<String, String> customHeaders);
}
