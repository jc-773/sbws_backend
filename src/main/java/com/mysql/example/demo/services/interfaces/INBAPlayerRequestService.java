package com.mysql.example.demo.services.interfaces;

import com.mysql.example.demo.responses.PlayerProjectionResponse;

public interface INBAPlayerRequestService {
    <T> T PlayerResponse_Get(Class<T> clazz,String token);
    <T> T PlayerProjection_Get(Class<PlayerProjectionResponse> clazz, String token, String playerId, String date);
}
