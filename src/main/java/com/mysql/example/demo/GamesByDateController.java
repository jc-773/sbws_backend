package com.mysql.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.example.demo.responses.GamesByDate;
import com.mysql.example.demo.responses.mobile.GamesByDateMobileResponse;
import com.mysql.example.demo.services.interfaces.IBackendRequestService;

@RestController
public class GamesByDateController {
    private final IBackendRequestService requests;
    private final IGamesByDateClientService gamesService;
    @Autowired
    public GamesByDateController(IBackendRequestService requests, IGamesByDateClientService gamesService) {
        this.requests = requests;
        this.gamesService = gamesService;
    }

    @RequestMapping(value = "/nba/gamesByDate", method=RequestMethod.GET)
    public ResponseEntity<List<GamesByDateMobileResponse>> getGamesByDate(@RequestParam(value = "key") String key, @RequestParam(value = "date") String date) {
        try {
            List<GamesByDate> gamesByDateResponse = requests.GamesByDate_Get(date, key);
            return gamesService.returnGamesByDate(gamesByDateResponse);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }
}
