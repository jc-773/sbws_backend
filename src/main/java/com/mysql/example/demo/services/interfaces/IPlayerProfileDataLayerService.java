package com.mysql.example.demo.services.interfaces;

import java.util.List;

import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.containers.PlayerResponseContainer;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponseType;

public interface IPlayerProfileDataLayerService {
    public void savePlayer(PlayerProfileResponseType playerProfileResponseType);
    public void savePlayers(List<PlayerResponse> playerResponse);
    public PlayerResponseContainer findPlayerByPlayerID(String playerID);
}
