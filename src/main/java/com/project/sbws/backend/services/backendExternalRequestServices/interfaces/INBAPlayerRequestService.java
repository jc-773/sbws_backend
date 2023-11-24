package com.project.sbws.backend.services.backendExternalRequestServices.interfaces;

import com.project.sbws.backend.responses.PlayerProjectionResponse;

public interface INBAPlayerRequestService {
    <T> T PlayerResponse_Get(Class<T> clazz,String token);
    <T> T PlayerProjection_Get(Class<PlayerProjectionResponse> clazz, String token, String playerId, String date);
    <T> T PlayerByTeamResponse_Get(Class<T> clazz,String token, String team);
    <T> T PlayerCareerStats(Class<T> clazz, String playerID);
}

