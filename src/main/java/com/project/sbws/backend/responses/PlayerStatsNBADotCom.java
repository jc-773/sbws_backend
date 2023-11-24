package com.project.sbws.backend.responses;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerStatsNBADotCom {

    @JsonProperty("resource")
    public String resource;

    @JsonProperty("parameters")
    public ParametersNBADotCom parameters;

    @JsonProperty("resultSets")
    public ArrayList<ResultSets> resultSets;
}
