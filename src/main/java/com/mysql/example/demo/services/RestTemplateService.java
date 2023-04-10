package com.mysql.example.demo.services;

import java.util.Hashtable;
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
import com.mysql.example.demo.services.interfaces.IRestTemplateService;

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
    public <T, R> T getForObjectResponse(Class<T> clazz, String url, Hashtable<String, String> customHeaders) {
        try {
            System.out.println("Get request made to " + url);
            HttpHeaders headers = createHttpHeaders(customHeaders);
            HttpEntity httpEntity = new HttpEntity(headers);
            ObjectMapper objectMapper = new ObjectMapper();
            
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                    new ParameterizedTypeReference<T>() {
                    });

                   
            response.hasBody();
            return response.getBody();
        } catch (Exception e) {
           // LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public <T, R> PlayerProjectionResponse getForObjectResponseType(Class<PlayerProjectionResponse> clazz, String url, Hashtable<String, String> customHeaders) {
        try {
            System.out.println("Get request made to " + url);
            HttpHeaders headers = createHttpHeaders(customHeaders);
            HttpEntity httpEntity = new HttpEntity(headers);
            ObjectMapper objectMapper = new ObjectMapper();
            
            ResponseEntity<PlayerProjectionResponse> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<PlayerProjectionResponse>() {});
                   
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
