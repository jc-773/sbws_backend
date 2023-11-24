package com.project.sbws.backend.services.backendExternalRequestServices.interfaces;

public interface IGamesByDateRequestService {
    <T> T GamesByDateResponse_Get(Class<T> clazz, String date, String key);
}
