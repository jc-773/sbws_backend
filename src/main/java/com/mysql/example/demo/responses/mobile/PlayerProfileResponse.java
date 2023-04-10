package com.mysql.example.demo.responses.mobile;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerProfileResponse {
    @JsonProperty("response")
    public List<PlayerProfileResponseType> playerProfileResponseType;
}
