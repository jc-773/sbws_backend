package com.mysql.example.demo.services.dataServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.example.demo.repositories.AllPlayersRepository;
import com.mysql.example.demo.repositories.PlayerProfileRepository;
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.mobile.PlayerProfileResponseType;
import com.mysql.example.demo.services.interfaces.IPlayerProfileDataLayerService;

@Service
public class PlayerProfileDataService implements IPlayerProfileDataLayerService {
  
    @Autowired
    PlayerProfileRepository playerProfileRepository;

    @Autowired
    AllPlayersRepository allPlayersRepository;

    @Override
    public void savePlayer(PlayerProfileResponseType playerProfileResponseType) {
        playerProfileRepository.save(playerProfileResponseType);
    }

    @Override
    public void savePlayers(List<PlayerResponse> playerResponse) {
        allPlayersRepository.save(playerResponse);
    }
    

}
