package com.mysql.example.demo.services.backendExternalRequestServices.interfaces;

import java.util.Hashtable;

import com.mysql.example.demo.responses.PlayerProjectionResponse;

public interface IRestTemplateService {
    public <T, R> T getForObjectResponse(Class<T> clazz, String url, Hashtable<String, String> customHeaders);
    public <T, R> PlayerProjectionResponse getForObjectResponseType(Class<PlayerProjectionResponse> clazz, String url, Hashtable<String, String> customHeaders);
}
