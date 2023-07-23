package com.mysql.example.demo.services.backendExternalRequestServices.interfaces;

public interface IAllNBATeamsRequestService {
    <T> T AllTeams_Get(Class<T> clazz);
}
