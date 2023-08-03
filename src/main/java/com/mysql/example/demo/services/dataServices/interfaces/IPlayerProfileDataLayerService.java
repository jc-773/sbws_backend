package com.mysql.example.demo.services.dataServices.interfaces;

import java.util.List;
import java.util.Map;

import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.containers.PlayerResponseContainer;
import com.mysql.example.demo.responses.mobile.PlayerByTeamMobileResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponseType;

public interface IPlayerProfileDataLayerService {
    public void savePlayer(PlayerProfileResponseType playerProfileResponseType);
    public void savePlayers(List<PlayerResponse> playerResponse);
    public PlayerResponseContainer findPlayerByPlayerID(String playerID);
    public PlayerByTeamMobileResponse findPlayerByNBADotComPlayerId(int nBADotComPlayerId);
    public void saveOverallBasePlayerDashboardFromNBADotCom(Map<String, String> playerStatsMap);
    public void savePlayersByTeam(List<PlayerByTeamMobileResponse> playerResponse);
    public void deletePlayerByTeamCollectionForNewInstances();
    public void dropCollection(String collectionName);
    public List<Integer> returnAllPlayerIds();
}
