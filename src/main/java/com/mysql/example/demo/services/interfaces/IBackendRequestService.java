package com.mysql.example.demo.services.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.RequestHeader;

import com.mysql.example.demo.responses.GamesByDate;
import com.mysql.example.demo.responses.PlayerProjectionResponse;
import com.mysql.example.demo.responses.PlayerResponse;
import com.mysql.example.demo.responses.mobile.GamesByDateMobileResponse;

public interface IBackendRequestService {
    public List<PlayerResponse> PlayerInformation_Get(@RequestHeader String key);
    public PlayerProjectionResponse PlayerProjection_Get(String key, String playerId, String date);
    public  List<GamesByDate> GamesByDate_Get( String date, String key);
}
