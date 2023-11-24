package com.project.sbws.backend.responses.mobile;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerProfileResponse {
    @JsonProperty("response")
    public List<PlayerProfileResponseType> playerProfileResponseType;
}
