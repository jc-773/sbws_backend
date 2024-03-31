package com.project.sbws.backend.services.interfaces;

public interface INBAPlayerRequestService {
  
    <T> T PlayerCareerStats(Class<T> clazz, String playerID);
}

