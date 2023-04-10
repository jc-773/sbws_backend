// package com.mysql.example.demo.controllers;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RequestHeader;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.client.RestTemplate;

// import com.mysql.example.demo.PlayerService;
// import com.mysql.example.demo.TestRepository;
// import com.mysql.example.demo.responses.PlayerResponse;
// import com.mysql.example.demo.services.interfaces.IBackendRequestService;

// @RestController 
// public class NBAPlayerController {

//     private final IBackendRequestService requests;
//     private final PlayerService playerService;
    
//     @Autowired
//     public NBAPlayerController(IBackendRequestService requests, PlayerService playerService) {
//         this.requests = requests;
//         this.playerService = playerService;
//     }

//     RestTemplate restTemplate;

//     @RequestMapping(value = "/nba/player", method=RequestMethod.GET)
//     public String getPlayerProfile(@RequestHeader(value = "Ocp-Apim-Subscription-Key") String sdToken, @RequestHeader(value = "X-RapidAPI-Key") String token, 
//     @RequestHeader(value = "X-RapidAPI-Host") String host, @RequestHeader String playerFirstName, @RequestHeader String playerLastName) {
//        try {
//            List<PlayerResponse> playerResponse =  requests.PlayerInformation_Get(sdToken);
           
//            playerService.savePlayer(playerResponse);
//            return "Yoo";
//         } catch (Exception e) {
//            // LOGGER.info(e.getMessage() );
//        }
       
//         return null;
        
//     }
// }
