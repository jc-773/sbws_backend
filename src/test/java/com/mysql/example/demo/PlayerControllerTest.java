package com.mysql.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.project.sbws.backend.controllers.nba.PlayerController;
import com.project.sbws.backend.responses.PlayerProjectionResponse;
import com.project.sbws.backend.responses.mobile.PlayerProfileResponse;
import com.project.sbws.backend.services.clientRequestServices.implementations.PlayerService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

public class PlayerControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerService playerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(playerController).build();
    }

    @Test
    public void testGetPlayerProfile() throws Exception {
        String playerID = "1";
        String date = "2022-01-01";
        String key = "testKey";

        ResponseEntity<PlayerProfileResponse> playerProfileResponse = new ResponseEntity<>(new PlayerProfileResponse(),
                HttpStatus.OK);
        List<PlayerProjectionResponse> playerProjectionResponse = Collections
                .singletonList(new PlayerProjectionResponse());

        when(playerService.returnPlayerProfileFromBackend(playerID, playerProjectionResponse, null))
                .thenReturn(playerProfileResponse);

        mockMvc.perform(get("/nba/players")
                .header("playerID", playerID)
                .header("date", date)
                .param("key", key)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
