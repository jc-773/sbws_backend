package com.mysql.example.demo.services.backendExternalRequestServices.implementations;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerStatsNBADotCom;
import com.mysql.example.demo.services.backendExternalRequestServices.interfaces.IRestTemplateService;

@Service
public class RestTemplateService implements IRestTemplateService{

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateService.class);
    @Autowired
    private RestTemplate restTemplate;
    
   @Autowired
    public RestTemplateService(RestTemplate restTemplate) {
       this.restTemplate = restTemplate;
    }

    @Override
    public <PlayerStatsNBADotCom> PlayerStatsNBADotCom getForObjectResponse(Class<PlayerStatsNBADotCom> clazz, String url, Hashtable<String, String> customHeaders) {
        try {
            System.out.println("Get request made to: " + url);
            HttpHeaders headers = createHttpHeaders(customHeaders);
            HttpEntity httpEntity = new HttpEntity(headers);
            //ObjectMapper objectMapper = new ObjectMapper();
            ObjectMapper mapper = new ObjectMapper();
          
            ResponseEntity<PlayerStatsNBADotCom> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                    new ParameterizedTypeReference<PlayerStatsNBADotCom>() {
                    });

                    Map<String, PlayerStatsNBADotCom> playerProfMap = new HashMap<>();
                            playerProfMap.put("key", response.getBody());
            response.hasBody();
            return response.getBody();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public <T, R> T getForObjectResponseType(Class<T> clazz, String url, Hashtable<String, String> customHeaders) {
        try {
            System.out.println("Get request made to " + url);
            HttpHeaders headers = createHttpHeaders(customHeaders);
            HttpEntity httpEntity = new HttpEntity(headers);
            ObjectMapper objectMapper = new ObjectMapper();
            
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<T>() {});
                   
            response.hasBody();
            return response.getBody();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    private HttpHeaders createHttpHeaders(Hashtable<String, String> customeHeaders) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (customeHeaders != null) {
            Set<String> headerKeys = customeHeaders.keySet();
            for (String headerKey : headerKeys) {
                headers.add(headerKey, customeHeaders.get(headerKey));
            }
        }
        return headers;
    }
    
}
