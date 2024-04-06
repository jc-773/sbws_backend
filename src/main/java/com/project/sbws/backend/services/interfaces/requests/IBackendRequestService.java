package com.project.sbws.backend.services.interfaces.requests;

public interface IBackendRequestService {
    <T> T PlayerCareerStats(Class<T> clazz, String playerID);
    <T> T PlayersOnCurrentTeamRoster(Class<T> clazz, String teamName);
}
