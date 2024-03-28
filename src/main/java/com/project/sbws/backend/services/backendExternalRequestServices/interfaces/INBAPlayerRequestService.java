package com.project.sbws.backend.services.backendExternalRequestServices.interfaces;

public interface INBAPlayerRequestService {
  
    <T> T PlayerCareerStats(Class<T> clazz, String playerID);
}

