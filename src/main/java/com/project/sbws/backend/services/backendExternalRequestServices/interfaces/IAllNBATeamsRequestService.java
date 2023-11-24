package com.project.sbws.backend.services.backendExternalRequestServices.interfaces;

public interface IAllNBATeamsRequestService {
    <T> T AllTeams_Get(Class<T> clazz);
}
