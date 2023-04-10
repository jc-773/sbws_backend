package com.mysql.example.demo.responses.containers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.example.demo.responses.GamesByDate;

public class GamesByDateContainer {
    @JsonProperty("key")
    public List<GamesByDate> response;
}
